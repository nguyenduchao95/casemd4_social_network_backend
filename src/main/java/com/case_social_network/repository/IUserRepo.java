package com.case_social_network.repository;


import com.case_social_network.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IUserRepo extends CrudRepository<User, Integer> {
    @Query(value = "select u from User u where u.username =:username")
    User findByUsername(String username);

    User findByUsernameAndPassword(String username , String password);
    // login ok
    @Query(value = "select u from User u where u.username =:username and u.password =:password ")
    User checkUser(@Param( "username") String username , @Param( "password") String password);

    User findUserById(long id);

    User findUserByResetPasswordToken(String token);

    @Query( nativeQuery = true , value = "select * from users u where u.email = :email")
    User findUserByEmail(@Param("email") String email);
}
