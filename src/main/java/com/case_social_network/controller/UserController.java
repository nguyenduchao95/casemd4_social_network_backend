package com.case_social_network.controller;

import com.case_social_network.entity.User;
import com.case_social_network.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/home")
    public String login(){
        return "home";
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editProfile(@RequestBody User user){

        User userE = userService.findUserById(user.getId());
        if (userE != null){
            user.setPassword(userE.getPassword());
            user.setCreated_at(userE.getCreated_at());
            user.setUpdated_at(LocalDate.now());
            user.setRoles(userE.getRoles());
            userService.edit(user);
        }
        return new ResponseEntity<>("edit success" , HttpStatus.OK);
    }
}
