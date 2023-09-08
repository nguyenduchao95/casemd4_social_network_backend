package com.case_social_network.service;
import com.case_social_network.entity.Like;
import com.case_social_network.entity.Post;
import java.util.List;

public interface ILikeService {
    Long countByPostId(Post post);
    List<Long> findUserIdsByPostId(Long postId);
    Like save(Like like);
    Like delete(Like like);
    Like findLikeByPostIdAndUserId(long postId, long userId);
    void deleteAllByPostId(Long postId);
}
