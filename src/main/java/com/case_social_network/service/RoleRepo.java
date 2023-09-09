package com.case_social_network.service;


import com.case_social_network.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Integer> {
}
