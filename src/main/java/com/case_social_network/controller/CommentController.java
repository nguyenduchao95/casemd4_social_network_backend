package com.case_social_network.controller;
import com.case_social_network.entity.Comment;
import com.case_social_network.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    ICommentService commentService;

    @GetMapping
    public List<Comment> showAll() {
        return commentService.getAll();
    }

    @PostMapping
    public Comment save(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

    @GetMapping("/{id}")
    public Comment edit(@PathVariable long id) {
        return commentService.findById(id);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        commentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<Comment> findByUsernameContain(@RequestParam String content) {
        return null;
    }
}