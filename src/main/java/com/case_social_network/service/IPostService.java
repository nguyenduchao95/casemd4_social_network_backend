package com.case_social_network.service;

import com.case_social_network.entity.Post;

import java.util.List;

public interface IPostService extends IService<Post> {
    List<Post> getAllByUserId(Long userId);
    List<Post> getAllByFollow(Long id);
}
