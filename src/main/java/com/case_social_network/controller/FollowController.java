package com.case_social_network.controller;

import com.case_social_network.entity.Follow;
import com.case_social_network.entity.User;
import com.case_social_network.service.IFollowService;
import com.case_social_network.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/{userId}/follows")
public class FollowController {
    @Autowired
    IFollowService followService;
    @Autowired
    IUserService userService;


    @GetMapping
    public List<User> showAll(@PathVariable Long userId) {
        return followService.findUsersFollowingUserId(userId);
    }
    @PostMapping
    public Follow addFollow( @RequestBody Follow follow, @PathVariable Long userId) {
        User user = userService.findById(userId);
        follow.setFollower_user(user);
        return followService.save(follow);
    }


}

