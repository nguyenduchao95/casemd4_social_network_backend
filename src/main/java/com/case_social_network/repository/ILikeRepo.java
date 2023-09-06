package com.case_social_network.repository;

import com.case_social_network.entity.Like;
import com.case_social_network.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ILikeRepo extends CrudRepository<Like,Long> {
    @Query("SELECT l FROM Like l WHERE l.id IN (SELECT p.id FROM Post p WHERE l.id = ?1)")
    List<Like> getAllByPost(Long postId);
}
