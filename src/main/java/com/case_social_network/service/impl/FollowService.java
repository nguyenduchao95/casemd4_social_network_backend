package com.case_social_network.service.impl;

import com.case_social_network.entity.Follow;
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
    public List<Follow> getAll() {
        return (List<Follow>) followRepo.findAll();
    }

    @Override
    public Follow save(Follow follow) {
        return followRepo.save(follow);
    }

    @Override
    public void delete(long id) {
        followRepo.deleteById(id);
    }

    @Override
    public Follow findById(long id) {
        return followRepo.findById(id).get();
    }

    @Override
    public List<Follow> findByStr(String name) {
        return null;
    }
}
