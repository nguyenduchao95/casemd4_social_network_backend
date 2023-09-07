package com.case_social_network.repository;

import com.case_social_network.entity.Follow;
import com.case_social_network.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IFollowRepo extends CrudRepository<Follow,Long> {
    List<Follow> findByFollowerUser(User followerUser);
    List<Follow> findAllByFollower_user(User user);

}
