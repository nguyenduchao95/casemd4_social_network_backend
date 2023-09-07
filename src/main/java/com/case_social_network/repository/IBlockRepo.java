package com.case_social_network.repository;

import com.case_social_network.entity.Block;
import com.case_social_network.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IBlockRepo extends CrudRepository<Block, Long> {

    @Query("SELECT b FROM Block b WHERE b.user.id = :userId")
    List<Block> findBlocksByUserId(@Param("userId") Long userId);

    @Query("SELECT b FROM Block b WHERE b.block_user = :blockUser AND b.user = :user")
    Block checkFollowed(@Param("user") User user,@Param("blockUser") User blockUser);
}
