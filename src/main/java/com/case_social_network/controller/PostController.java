package com.case_social_network.controller;

import com.case_social_network.entity.Post;
import com.case_social_network.service.ICommentService;
import com.case_social_network.service.ILikeService;
import com.case_social_network.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private IPostService postService;
    @Autowired
    private ICommentService commentService;
    @Autowired
    private ILikeService likeService;


    @GetMapping("/{userId}")
    public List<Post> getPostsFromFollowers(@PathVariable long userId) {
        return postService.getAllByFollow(userId);
    }

    @GetMapping
    public List<Post> showAll() {
        return postService.getAll();
    }

    @PostMapping
    public Post save(@RequestBody Post post) {
        return postService.save(post);
    }

    @PutMapping("/{id}")
    public Post edit(@RequestBody Post post) {
        return postService.save(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        likeService.deleteAllByPostId(id);
        commentService.deleteAllByPostId(id);
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<Post> findByUsernameContain(@RequestParam String content) {
        return postService.findByStr(content);
    }
}