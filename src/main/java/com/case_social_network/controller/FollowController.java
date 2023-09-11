package com.case_social_network.controller;

import com.case_social_network.entity.Follow;
import com.case_social_network.entity.Like;
import com.case_social_network.entity.Post;
import com.case_social_network.entity.User;
import com.case_social_network.service.IFollowService;
import com.case_social_network.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

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
    public List<User> showAll(@PathVariable Long userId) {
        return followService.listUserFollowed(userId);
    }
    @PostMapping("/{userFlId}")
    public Follow saveLike(@PathVariable Long userId, @PathVariable Long userFlId) {

        User user = userService.findById(userId);
        User userFl = userService.findById(userFlId);

        Follow follow = followService.checkFollowed(user, userFl);

        if (follow != null) {
            followService.delete(follow);
            return null;
        } else {
            Follow newFollow = new Follow(user, userFl);
            followService.save(newFollow);
            return newFollow;
        }

    }



}

