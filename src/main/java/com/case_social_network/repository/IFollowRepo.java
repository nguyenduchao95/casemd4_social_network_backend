package com.case_social_network.repository;

import com.case_social_network.entity.Follow;
import org.springframework.data.repository.CrudRepository;

public interface IFollowRepo extends CrudRepository<Follow,Long> {

}
