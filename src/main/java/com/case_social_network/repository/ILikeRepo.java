package com.case_social_network.repository;
import com.case_social_network.entity.Like;
import com.case_social_network.entity.Post;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ILikeRepo extends CrudRepository<Like,Long> {
    Long countByPost(Post post);
    @Query("SELECT l.user.id FROM Like l WHERE l.post.id = :postId")
    List<Long> findUserIdsByPostId(@Param("postId") Long postId);
    @Modifying
    @Query(nativeQuery = true, value="DELETE FROM likes l WHERE l.post_id = :postId and l.user_id = :userId")
    void deleteByPostIdAndUserId(@Param("postId") long postId, @Param("userId") long userId);

    @Override
    void delete(Like like);

    @Query(nativeQuery = true, value="SELECT * from likes l where l.post_id = :postId and l.user_id = :userId")
    Like getLike(@Param("postId") long postId, @Param("userId") long userId);

    Like findByPostIdAndUserId(long postId, long userId);
}
