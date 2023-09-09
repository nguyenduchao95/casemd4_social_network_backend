package com.case_social_network.controller;

import com.case_social_network.entity.User;
import com.case_social_network.entity.dto.UserToken;
import com.case_social_network.service.IUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IUserService iUserService;


    @PostMapping
    public ResponseEntity<?> login(@RequestBody User user) {

               try{
                   Authentication authentication = authenticationManager.authenticate(
                           new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

                   SecurityContextHolder.getContext().setAuthentication(authentication);
                   String token = createToken(user.getUsername());
                   User user1 = iUserService.findByUsername(user.getUsername());
                   UserToken userToken = new UserToken(
                           user1.getId(),
                           user1.getFirstName(),
                           user1.getLastName(),
                           user1.isGender(),
                           user1.getUsername(),
                           user1.getEmail(),
                           user1.getImage(),
                           user1.getCreated_at(),
                           user1.getUpdated_at(),
                           token,
                           user1.getRoles()
                   );
                   return new ResponseEntity<>(userToken, HttpStatus.OK);
               }catch (Exception e){
                   return new ResponseEntity<>(null , HttpStatus.NOT_ACCEPTABLE);
        }

    }

    public static final String PRIVATE_KEY = "123456789999887abc";
    private static final long EXPIRE_TIME = 86400L;

    // hàm tạo ra token
    public String createToken(String username) {
        return Jwts.builder()
                .setSubject((username))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + EXPIRE_TIME * 1000))
                .signWith(SignatureAlgorithm.HS512, PRIVATE_KEY)
                .compact();
    }

    @PostMapping("/fail")
    public String checkUser(@RequestBody User user) { // login fail
        return checkErr(user);
    }

    public String checkErr(User user) {
        String err = "";
        if (iUserService.findByUsername(user.getUsername()) != null){
            if (iUserService.findByUsernameAndPassword(user.getUsername(), user.getPassword()) == null){
                err = "wrong password";
            }
        } else {
            err = "wrong username";
        }

        return err;
    }
}
