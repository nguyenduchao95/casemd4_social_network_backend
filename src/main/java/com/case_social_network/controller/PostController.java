package com.case_social_network.controller;

import com.case_social_network.entity.Post;
import com.case_social_network.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/{userId}")
public class PostController {
    @Autowired
    IPostService postService;

    @GetMapping
    public List<Post> getPostsFromFollowers(@PathVariable Long userId) {
        return postService.getAllByFollow(userId);
    }

    @PostMapping
    public Post save(@RequestBody Post post) {
        return postService.save(post);
    }

    @GetMapping("/{id}")
    public Post edit(@PathVariable long id) {
        return postService.findById(id);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<Post> findByUsernameContain(@RequestParam String content) {
        return postService.findByStr(content);
    }
}