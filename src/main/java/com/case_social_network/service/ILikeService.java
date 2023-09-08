package com.case_social_network.service;

import com.case_social_network.entity.Like;
import com.case_social_network.entity.Post;

import java.util.List;

public interface ILikeService {
    Long countByPostId(Post post);
    List<Long> findUserIdsByPostId(Long postId);
    List<Like> getAllByPost(Post post);
}
