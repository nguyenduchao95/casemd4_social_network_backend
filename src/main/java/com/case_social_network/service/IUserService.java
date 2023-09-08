package com.case_social_network.service;

import com.case_social_network.entity.User;

import java.util.List;

public interface IUserService extends IService<User> {
    List<User> listUserFollowed(Long userId);
    List<User> listUserUnFollowed(Long userFlId);
    List<User> listUserFollowing(Long userId);
}
