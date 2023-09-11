package com.case_social_network.controller;

import com.case_social_network.service.IBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/blocks/{userId}")
public class BlockController {
    @Autowired
    private IBlockService blockService;

    @PostMapping("/{blockUserId}")
    public ResponseEntity<?> save(@PathVariable Long userId, @PathVariable Long blockUserId) {
        try {
            blockService.saveOrDelete(userId, blockUserId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
        }
    }

    @GetMapping("/{blockUserId}")
    public boolean checkBlocked(@PathVariable Long userId, @PathVariable Long blockUserId) {
        return blockService.findByUserIdAndBlockUserId(userId, blockUserId) != null;
    }
}
