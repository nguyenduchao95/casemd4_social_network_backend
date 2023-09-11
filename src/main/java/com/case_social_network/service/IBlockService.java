package com.case_social_network.service;
import com.case_social_network.entity.Block;

public interface IBlockService{
    Block findByUserIdAndBlockUserId(Long userId, Long blockUserId);
    void delete(Block block);
    void saveOrDelete(Long userId, Long blockUserId);
}
