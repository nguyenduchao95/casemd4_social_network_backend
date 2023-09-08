package com.case_social_network.service;

import com.case_social_network.entity.Follow;

public interface IFollowService{
    void delete(Follow follow);
    Follow findByUserIdAndFollowerUserId(Long userId, Long userFlId);
    Follow save(Follow follow);
}
