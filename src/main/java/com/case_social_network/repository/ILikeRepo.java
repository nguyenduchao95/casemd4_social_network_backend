package com.case_social_network.repository;

import com.case_social_network.entity.Like;
import com.case_social_network.entity.Post;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.List;

public interface ILikeRepo extends CrudRepository<Like, Long> {
    Long countByPost(Post post);

    @Query("SELECT l.user.id FROM Like l WHERE l.post.id = :postId")
    List<Long> findUserIdsByPostId(@Param("postId") Long postId);

    @Modifying
    @Transactional
    void deleteAllByPostId(Long postId);

    Like findByPostIdAndUserId(long postId, long userId);
}
