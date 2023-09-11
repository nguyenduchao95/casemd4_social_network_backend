package com.case_social_network.controller;


import com.case_social_network.configSercurity.reset_password.ForwardEmail;
import com.case_social_network.configSercurity.reset_password.UserNotFoundException;

import com.case_social_network.entity.User;
import com.case_social_network.entity.dto.UserToken;
import com.case_social_network.service.IUserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@RestController
@CrossOrigin("*")
@RequestMapping("/forgot-password")
public class ForgotPassWordController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/check-email")
    public ResponseEntity<?> checkEmail(@RequestBody ForwardEmail forwardEmail) {

        String token = RandomString.make(45);
        try {
            iUserService.updateResetPassword(token, forwardEmail.getEmail());
            UserToken userToken = new UserToken(token);
            sendEmail(forwardEmail.getEmail(), token); // gui code den email

            return new ResponseEntity<>(userToken, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (UnsupportedEncodingException | MessagingException e) {
            return new ResponseEntity<>("send code to email fail", HttpStatus.BAD_GATEWAY);
        }

    }

    public void sendEmail(String email, String codeToken) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("contact@xxx.com", "xxxSupport");
        helper.setTo(email);
        String subject = "Here's the code to confirm to reset your password";
        helper.setSubject(subject);
        helper.setText(codeToken);

        mailSender.send(message);
    }

    @PostMapping("/check-code")
    public ResponseEntity<?> checkCode(@RequestBody UserToken userToken) {
        User user = iUserService.getByResetPasswordToken(userToken.getToken());

        if (user != null) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/reset")
    public ResponseEntity<?> resetPassword(@RequestBody UserToken userToken) {
        User user = iUserService.findByEmail(userToken.getEmail());
        if (user != null) {
            iUserService.updatePassword(user, userToken.getToken());
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
