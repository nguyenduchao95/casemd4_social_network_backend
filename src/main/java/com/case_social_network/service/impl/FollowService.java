package com.case_social_network.service.impl;
import com.case_social_network.entity.Follow;
import com.case_social_network.entity.User;
import com.case_social_network.repository.IFollowRepo;
import com.case_social_network.service.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService implements IFollowService {
    @Autowired
    IFollowRepo followRepo;


    @Override
    public List<User> listUser(Long userFlId) {
        return followRepo.listUser(userFlId);
    }

    @Override
    public List<User> listUserFollowed(Long userId) {
        return followRepo.listUserFollowed(userId);
    }


    public Follow save(Follow follow) {
        return followRepo.save(follow);
    }


    public void delete(Follow follow) {
        followRepo.delete(follow);

    }

    @Override
    public Follow checkFollowed(User user, User userFl) {
        return followRepo.checkFollowed(user, userFl);
    }

}