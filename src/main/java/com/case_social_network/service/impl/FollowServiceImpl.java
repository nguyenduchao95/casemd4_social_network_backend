package com.case_social_network.service.impl;

import com.case_social_network.entity.Follow;
import com.case_social_network.entity.User;
import com.case_social_network.repository.IFollowRepo;
import com.case_social_network.service.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements IFollowService {
    @Autowired
    private IFollowRepo followRepo;

    @Override
    public void saveOrDelete(Long userId, Long userFlId) {
        Follow follow = followRepo.findByUserIdAndFollowedUserId(userId, userFlId);
        if (follow != null) {
            followRepo.delete(follow);
        } else {
            User user = new User();
            user.setId(userId);
            User userFl = new User();
            userFl.setId(userFlId);
            Follow newFollow = new Follow(userFl, user);
            followRepo.save(newFollow);
        }
    }

    @Override
    public void delete(Follow follow) {
        followRepo.delete(follow);
    }

    @Override
    public Follow findByUserIdAndFollowerUserId(Long userId, Long userFlId) {
        return followRepo.findByUserIdAndFollowedUserId(userId, userFlId);
    }

}