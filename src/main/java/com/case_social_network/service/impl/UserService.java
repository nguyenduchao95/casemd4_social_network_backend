package com.case_social_network.service.impl;

import com.case_social_network.entity.User;
import com.case_social_network.repository.IUserRepo;
import com.case_social_network.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepo userRepo;
    @Override
    public List<User> getAll() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public User findById(long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<User> findByStr(String name) {
        return null;
    }


    @Override
    public List<User> listUserFollowed(Long userId) {
        return userRepo.listUserFollowed(userId);
    }

    @Override
    public List<User> listUserUnFollowed(Long userFlId) {
        return userRepo.listUserUnFollowed(userFlId);
    }

    @Override
    public List<User> listUserFollowing(Long userId) {
        return userRepo.listUserFollowing(userId);
    }
}
