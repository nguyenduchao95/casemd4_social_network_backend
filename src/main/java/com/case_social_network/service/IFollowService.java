package com.case_social_network.service;

import com.case_social_network.entity.Follow;
import com.case_social_network.entity.User;

import java.util.List;

public interface IFollowService extends IService<Follow>{
    List<Follow> getAllForUser();

    List<Follow> getAllForUser(User user);
}
