package com.case_social_network.controller;

import com.case_social_network.entity.Comment;
import com.case_social_network.entity.Post;
import com.case_social_network.service.ICommentService;
import com.case_social_network.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cmt/{postId}")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @Autowired
    private IPostService postService;

    @GetMapping

    public List<Comment> showAllComments(@PathVariable Long postId) {
        Post post = postService.findById(postId);
        return commentService.findAllByPost(post);
    }

    @PostMapping
    public Comment createComment(@PathVariable Long postId, @RequestBody Comment comment) {
        Post post = postService.findById(postId);
        comment.setPost(post);
        return commentService.save(comment);
    }

    @GetMapping("/{commentId}")
    public Comment edit(@PathVariable Long commentId, @PathVariable String postId) {
        return commentService.findById(commentId);
    }
    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId, @PathVariable String postId) {
        commentService.delete(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}