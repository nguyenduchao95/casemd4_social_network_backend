package com.case_social_network.controller;

import com.case_social_network.entity.Role;
import com.case_social_network.entity.User;
import com.case_social_network.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/registers")
public class RegisterController {

    @Autowired
    private IUserService iUserService;
    @Value("${upload.profile.path}")
    private String fileUpload;
    @PostMapping
    public ResponseEntity<String> createUser(@RequestParam("file") MultipartFile file,
                                             @RequestParam(value = "firstName") String firstName,
                                             @RequestParam(value = "lastName") String lastName,
                                             @RequestParam(value = "gender") boolean gender,
                                             @RequestParam(value = "email") String email,
                                             @RequestParam(value = "username") String username,
                                             @RequestParam(value = "password") String password) throws IOException {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        String fileName = file.getOriginalFilename();
        String filePath = fileUpload + "/" + fileName;
        File imageFile = new File(filePath);
        if (!imageFile.exists()){
            file.transferTo(imageFile);
        }
        User user = new User(firstName, lastName, gender, email, username, encodedPassword);
        Role role = new Role();
        role.setId(2);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        LocalDateTime now = LocalDateTime.now();
        user.setImage(fileName);
        user.setCreated_at(now);
        user.setUpdated_at(now);
        iUserService.save(user);
        return new ResponseEntity<>("create success" , HttpStatus.OK);
    }
}
