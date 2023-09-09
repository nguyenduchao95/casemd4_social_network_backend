package com.case_social_network.controller;

import com.case_social_network.entity.Post;
import com.case_social_network.entity.User;
import com.case_social_network.service.ICommentService;
import com.case_social_network.service.ILikeService;
import com.case_social_network.service.IPostService;
import com.case_social_network.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
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
    @Autowired
    IUserService userService;
    @Value("${upload.posts.path}")
    private String fileUpload;

    @GetMapping("/{userId}")
    public List<Post> getPostsFromFollowers(@PathVariable long userId) {
        return postService.getAllByFollow(userId);
    }

    @GetMapping("/users/{userId}")
    public List<Post> getAllByUserId(@PathVariable long userId) {
        return postService.getAllByUserId(userId);
    }

    @GetMapping
    public List<Post> showAll() {
        return postService.getAll();
    }

    @PostMapping("/{userId}")
    public ResponseEntity<?> save(@RequestParam("file") MultipartFile file,
                                  @RequestParam(value = "content") String content,
                                  @PathVariable Long userId) {
        try {
            String fileName = file.getOriginalFilename();
            String filePath = fileUpload + "/" + fileName;
            file.transferTo(new File(filePath));
            Post post = new Post();
            post.setImg(fileName);
            post.setContent(content);
            post.setCreated_at(LocalDateTime.now());
            User user = new User();
            user.setId(userId);
            post.setUser(user);
            Post savedPost = postService.save(post);
            return new ResponseEntity<>(savedPost, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
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