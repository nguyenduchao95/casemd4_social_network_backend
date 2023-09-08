package com.case_social_network.repository;

import com.case_social_network.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserRepo extends CrudRepository<User,Long> {

}
