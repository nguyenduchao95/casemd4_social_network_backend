package com.case_social_network.service.impl;

import com.case_social_network.entity.User;
import com.case_social_network.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public List<User> getAll() {
        return null;
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
        return null;
    }

    @Override
    public List<User> findByStr(String name) {
        return null;
    }
}
