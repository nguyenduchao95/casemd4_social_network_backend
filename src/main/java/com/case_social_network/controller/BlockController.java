package com.case_social_network.controller;
import com.case_social_network.entity.Block;
import com.case_social_network.entity.User;
import com.case_social_network.service.impl.BlockService;
import com.case_social_network.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/blocks/{userId}")
public class BlockController  {
    @Autowired
    private BlockService blockService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Block> getBlocksByUser(@PathVariable Long userId) {
        return blockService.findBlocksByUserId(userId);
    }

    @PostMapping("/{blockUserId}")
    public Block saveLike(@PathVariable Long userId, @PathVariable Long blockUserId) {

        User user = userService.findById(userId);
        User blockUser = userService.findById(blockUserId);

        Block block = blockService.checkFollowed(user, blockUser);

        if (block != null) {
            blockService.delete(block);
            return null;
        } else {
            Block newBlock = new Block(user, blockUser);
            blockService.save(block);
            return newBlock;
        }

    }
}
