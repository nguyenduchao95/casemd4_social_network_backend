package com.case_social_network.repository;

import com.case_social_network.entity.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IBlockRepo extends JpaRepository<Block, Long> {
    Block findByUserIdAndBlockUserId(Long userId, Long blockUserId);
}
