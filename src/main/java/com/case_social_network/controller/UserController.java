package com.case_social_network.controller;

import com.case_social_network.entity.User;
import com.case_social_network.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;
    @Value("${upload.profile.path}")
    private String fileUpload;

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.findUserById(userId);
    }

   @PostMapping("/edit")
    public ResponseEntity<?> editProfile(@RequestBody User user) {

        User userE = userService.findUserById(user.getId());
        if (userE != null) {
            user.setPassword(userE.getPassword());
            user.setCreated_at(userE.getCreated_at());
            user.setUpdated_at(LocalDateTime.now());
            user.setRoles(userE.getRoles());
            userService.edit(user);
        }
        return new ResponseEntity<>("edit success", HttpStatus.OK);
    }

    @PutMapping("/edit/{userId}")
    public ResponseEntity<?> editProfile2(@RequestParam(name = "file", required = false) MultipartFile file,
                                               @RequestParam("firstName") String firstName,
                                               @RequestParam("lastName") String lastName,
                                               @RequestParam("gender") boolean gender,
                                               @RequestParam("email") String email,
                                               @RequestParam("username") String username,
                                               @PathVariable Long userId){
        try {
        User userById = userService.findById(userId);
        User user = new User(firstName, lastName, gender, email, username);
        user.setId(userId);
        user.setPassword(userById.getPassword());
        user.setCreated_at(userById.getCreated_at());
        user.setUpdated_at(LocalDateTime.now());
        if (file != null) {
            String fileName = file.getOriginalFilename();
            String filePath = fileUpload + "/" + fileName;
            File imageFile = new File(filePath);
            if (!imageFile.exists()) {
                file.transferTo(imageFile);
            }
            user.setImage(fileName);
        } else {
            user.setImage(userById.getImage());
        }
        userService.edit(user);
        return new ResponseEntity<>("update success", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
