package com.case_social_network.service.impl;

import com.case_social_network.entity.Block;
import com.case_social_network.entity.User;
import com.case_social_network.repository.IBlockRepo;
import com.case_social_network.service.IBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlockService implements IBlockService {
    @Autowired
    IBlockRepo blockRepo;
    @Override
    public List<Block> findBlocksByUserId(Long userId) {
        return blockRepo.findBlocksByUserId(userId);
    }

    @Override
    public Block checkFollowed(User user, User blockUser) {
        return blockRepo.checkFollowed(user, blockUser);
    }

    @Override
    public void delete(Block block) {
        blockRepo.delete(block);
    }

    @Override
    public Block save(Block block) {
        return blockRepo.save(block);
    }
}
