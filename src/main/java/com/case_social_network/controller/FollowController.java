package com.case_social_network.controller;
import com.case_social_network.entity.Follow;
import com.case_social_network.service.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/follows")
public class FollowController {
    @Autowired
    IFollowService followService;

    @GetMapping
    public List<Follow> showAll() {
        return followService.getAll();
    }

    @PostMapping
    public Follow save(@RequestBody Follow follow) {
        return followService.save(follow);
    }

    @GetMapping("/{id}")
    public Follow edit(@PathVariable long id) {
        return followService.findById(id);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        followService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<Follow> findByUsernameContain(@RequestParam String content) {
        return followService.findByStr(content);
    }
}

