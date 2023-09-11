package com.case_social_network.controller;

import com.case_social_network.entity.Like;
import com.case_social_network.entity.Post;
import com.case_social_network.entity.User;
import com.case_social_network.service.ILikeService;
import com.case_social_network.service.IPostService;
import com.case_social_network.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/likes")
public class LikeController {
    @Autowired
    private IPostService postService;

    @Autowired
    private ILikeService likeService;

    @Autowired
    private IUserService userService;

    @GetMapping("/{postId}/count")
    public Long getLikeCount(@PathVariable Long postId) {
        return likeService.countByPostId(postService.findById(postId));
    }

    @PostMapping("/{postId}/{userId}")
    public ResponseEntity<?> saveLike(@PathVariable Long postId, @PathVariable Long userId) {
        try {;
            Like like = likeService.findLikeByPostIdAndUserId(postId, userId);
            if (like != null) {
                likeService.delete(like);
            } else {
                Post post = new Post();
                post.setId(postId);
                User user = new User();
                user.setId(userId);
                Like newLike = new Like(user, post);
                likeService.save(newLike);
            }
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
        }

    }

    @GetMapping("/{postId}/{userId}")
    public boolean checkLiked(@PathVariable Long postId, @PathVariable Long userId) {
        Like like = likeService.findLikeByPostIdAndUserId(postId, userId);
        return like != null;
    }

    @GetMapping("/{postId}/users")
    public List<User> getLikedUsers(@PathVariable Long postId) {
        List<Long> likedUserIds = likeService.findUserIdsByPostId(postId);
        List<User> likedUsers = new ArrayList<>();
        for (Long userId : likedUserIds) {
            User user = userService.findById(userId);
            if (user != null) {
                likedUsers.add(user);
            }
        }
        return likedUsers;
    }
}
