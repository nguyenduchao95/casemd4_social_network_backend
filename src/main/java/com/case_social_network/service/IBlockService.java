package com.case_social_network.service;
import com.case_social_network.entity.Block;
import com.case_social_network.entity.User;
import java.util.List;

public interface IBlockService{
    List<Block> findBlocksByUserId(Long userId);
    Block checkFollowed(User blockUser, User user);
    void delete(Block block);
    Block save(Block block);
}
