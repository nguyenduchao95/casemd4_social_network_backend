package com.case_social_network.repository;

import com.case_social_network.entity.Comment;
import com.case_social_network.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICommentRepo extends CrudRepository<Comment,Long> {
    @Query("SELECT c.user.id FROM Comment c WHERE c.post.id = :postId")
    List<Long> findUserIdsByPostId(@Param("postId") Long postId);
    List<Comment> findAllByPost(Post post);


}
