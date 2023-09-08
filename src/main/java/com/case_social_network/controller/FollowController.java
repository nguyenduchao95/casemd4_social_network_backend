package com.case_social_network.controller;

import com.case_social_network.entity.Follow;
import com.case_social_network.entity.Like;
import com.case_social_network.entity.Post;
import com.case_social_network.entity.User;
import com.case_social_network.service.IFollowService;
import com.case_social_network.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/follows/{userId}")
public class FollowController {
    @Autowired
    IFollowService followService;
    @Autowired
    IUserService userService;


    @GetMapping
    public List<User> listUserFollowed(@PathVariable Long userId) {
        return userService.listUserFollowed(userId);
    }

    @GetMapping("/unfollow")
    public List<User> listUserUnFollowed(@PathVariable Long userId) {
        return userService.listUserUnFollowed(userId);
    }

    @GetMapping("/following")
    public List<User> listUserFollowing(@PathVariable Long userId) {
        return userService.listUserFollowing(userId);
    }

    @PostMapping("/{userFlId}")
    public ResponseEntity<?> saveFollow(@PathVariable Long userId, @PathVariable Long userFlId) {
        try {
            Follow follow = followService.findByUserIdAndFollowerUserId(userId, userFlId);
            if (follow != null) {
                followService.delete(follow);
            } else {
                User user = new User();
                user.setId(userId);
                User userFl = new User();
                userFl.setId(userFlId);
                Follow newFollow = new Follow(user, userFl);
                followService.save(newFollow);
            }
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
        }
    }

    @GetMapping("/{userFlId}")
    public boolean checkFollowed(@PathVariable Long userId, @PathVariable Long userFlId) {
        return followService.findByUserIdAndFollowerUserId(userId, userFlId) != null;
    }



}

