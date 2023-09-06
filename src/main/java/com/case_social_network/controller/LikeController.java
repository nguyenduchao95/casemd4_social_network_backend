package com.case_social_network.controller;

import com.case_social_network.entity.Like;
import com.case_social_network.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/posts{postId}")
public class LikeController {
    @Autowired
    ILikeService likeSerVice;
    @GetMapping
    public List<Like> getAll(){
        return likeSerVice.getAll();
    }
    @PostMapping
    public Like save(Like like){
        return likeSerVice.save(like);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        likeSerVice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
