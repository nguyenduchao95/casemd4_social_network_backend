package com.case_social_network.repository;

import com.case_social_network.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPostRepo extends CrudRepository<Post,Long> {

   @Query("SELECT p FROM Post p WHERE p.user.id IN (SELECT f.follower_user.id FROM Follow f WHERE f.user.id = ?1)")
   List<Post> getAllByFollow(Long userId);

   List <Post> findByContentContains(String content);
}
