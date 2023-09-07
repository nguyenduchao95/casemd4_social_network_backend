package com.case_social_network.controller;
import com.case_social_network.entity.Like;
import com.case_social_network.entity.User;
import com.case_social_network.service.ILikeService;
import com.case_social_network.service.IPostService;
import com.case_social_network.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return  likeService.countByPostId(postService.findById(postId));
    }
//    @GetMapping("{postId}/like")
//    public List<Like> getAll(@PathVariable Long postId){
//        return likeService.getAllByPost(postService.findById(postId));
//    }


    @GetMapping("/{postId}/liked-users")
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
