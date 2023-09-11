package com.case_social_network.service.impl;

import com.case_social_network.entity.Block;
import com.case_social_network.entity.Follow;
import com.case_social_network.entity.User;
import com.case_social_network.repository.IBlockRepo;
import com.case_social_network.repository.IFollowRepo;
import com.case_social_network.service.IBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockServiceImpl implements IBlockService {
    @Autowired
    private IBlockRepo blockRepo;
    @Autowired
    private IFollowRepo followRepo;

    @Override
    public Block findByUserIdAndBlockUserId(Long userId, Long blockUserId) {
        return blockRepo.findByUserIdAndBlockUserId(userId, blockUserId);
    }

    @Override
    public void delete(Block block) {
        blockRepo.delete(block);
    }

    @Override
    public void saveOrDelete(Long userId, Long blockUserId) {
        Block block = blockRepo.findByUserIdAndBlockUserId(userId, blockUserId);
        if (block != null) {
            blockRepo.delete(block);
        } else {
            User user = new User();
            user.setId(userId);
            User blockUser = new User();
            blockUser.setId(blockUserId);
            Block newBlock = new Block(blockUser, user);
            Follow follow = followRepo.findByUserIdAndFollowedUserId(userId, blockUserId);
            if (follow != null) followRepo.delete(follow);
            blockRepo.save(newBlock);
        }
    }
}
