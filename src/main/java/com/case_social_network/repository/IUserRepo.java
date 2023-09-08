package com.case_social_network.repository;

import com.case_social_network.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepo extends CrudRepository<User,Long> {
}
