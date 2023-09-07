package com.case_social_network.service;
import com.case_social_network.entity.Like;
import com.case_social_network.entity.Post;
import java.util.List;

public interface ILikeService {
    Long countByPostId(Post post);
    List<Long> findUserIdsByPostId(Long postId);
    Like save(Like like);
    Like delete(Like like);
    void deleteByPostIdAndUserId(long postId, long userId);

    List<Like> getAll();

    Like getLike(Long postId , Long userId);

    Like findLikeByPostIdAndUserId(long postId, long userId);
}
