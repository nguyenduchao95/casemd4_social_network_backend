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

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/posts")
public class LikeController {
    @Autowired
    private IPostService postService;

    @Autowired
    private ILikeService likeService;
    private IUserService userService;


    @GetMapping("/{postId}/like-count")
    public Long getLikeCount(@PathVariable Long postId) {
        return  likeService.countByPostId(postService.findById(postId));
    }


    // Lấy danh sách người dùng đã "like" bài viết
    @GetMapping("/{postId}/liked-users")
    public void getLikedUsers(@PathVariable Long postId) {
        List<Long> likedUserIds = likeService.findUserIdsByPostId(postId);
        System.out.println(likedUserIds);

    }
}
