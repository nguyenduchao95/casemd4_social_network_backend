package com.case_social_network.service;

import com.case_social_network.entity.Like;

import java.util.List;

public interface ILikeService extends IService<Like>{
    List<Like> getAllByPost(long postId);
}
