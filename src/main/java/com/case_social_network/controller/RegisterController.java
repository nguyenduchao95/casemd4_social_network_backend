package com.case_social_network.controller;

import com.case_social_network.entity.Role;
import com.case_social_network.entity.User;
import com.case_social_network.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/registers")
public class RegisterController {

    @Autowired
    IUserService iUserService;
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user){

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);


        Role role = new Role();
        role.setId(2);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        LocalDate now = LocalDate.now();
        user.setCreated_at(now);
        user.setUpdated_at(now);
        iUserService.save(user);
        return new ResponseEntity<>("create success" , HttpStatus.OK);
    }



}
