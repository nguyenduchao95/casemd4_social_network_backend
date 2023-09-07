package com.case_social_network.service.impl;

import com.case_social_network.entity.Block;
import com.case_social_network.entity.User;
import com.case_social_network.service.IBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlockService implements IBlockService {
    @Autowired
    IBlockService blockService;
    @Override
    public List<Block> findBlocksByUserId(Long userId) {
        return blockService.findBlocksByUserId(userId);
    }

    @Override
    public Block checkFollowed(User user, User blockUser) {
        return blockService.checkFollowed(user, blockUser);
    }

    @Override
    public void delete(Block block) {
        blockService.delete(block);
    }

    @Override
    public Block save(Block block) {
        return blockService.save(block);
    }
}
