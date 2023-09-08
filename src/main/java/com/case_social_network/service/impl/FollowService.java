package com.case_social_network.service.impl;

import com.case_social_network.entity.Follow;
import com.case_social_network.repository.IFollowRepo;
import com.case_social_network.service.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService implements IFollowService {
    @Autowired
    IFollowRepo followRepo;

    @Override
    public Follow save(Follow follow) {
        return followRepo.save(follow);
    }

    @Override
    public void delete(Follow follow) {
        followRepo.delete(follow);
    }

    @Override
    public Follow findByUserIdAndFollowerUserId(Long userId, Long userFlId) {
        return followRepo.findByUserIdAndFollowerUserId(userId, userFlId);
    }

}