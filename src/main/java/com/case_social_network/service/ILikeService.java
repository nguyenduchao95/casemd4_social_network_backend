package com.case_social_network.service;

import com.case_social_network.entity.Like;
import com.case_social_network.entity.Post;
import com.case_social_network.entity.User;

import java.util.List;

public interface ILikeService {
    Long countByPostId(Post post);
    List<Long> findUserIdsByPostId(Long postId);
    Like save(Like like);
    void delete(Long id);
    void deleteByPostIdAndUserId(long postId, long userId);

}
