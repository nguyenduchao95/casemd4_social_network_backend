package com.case_social_network.repository;

import com.case_social_network.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPostRepo extends CrudRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.user.id = :userId ORDER BY p.created_at DESC")
    List<Post> getAllByUserId(Long userId);

    @Query("SELECT p FROM Post p WHERE p.user.id IN (SELECT f.followedUser.id FROM Follow f WHERE f.user.id = :userId) OR p.user.id = :userId ORDER BY p.created_at DESC")
    List<Post> getAllByFollow(@Param("userId") Long userId);

    List<Post> findByContentContains(String content);
}
