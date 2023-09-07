package com.case_social_network.service;

import com.case_social_network.entity.Follow;
import com.case_social_network.entity.User;

import java.util.List;

public interface IFollowService{
    List<User> listUser(Long userFlId);
    List<User> listUserFollowed(Long userId);
    void delete(Follow follow);
    Follow checkFollowed(User user,User userFl);

}
