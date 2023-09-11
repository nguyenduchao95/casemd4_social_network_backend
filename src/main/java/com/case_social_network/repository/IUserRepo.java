package com.case_social_network.repository;

import com.case_social_network.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepo extends JpaRepository<User,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM users u WHERE u.id NOT IN (SELECT f.followed_user_id FROM follow f WHERE f.user_id = :followedId) AND u.id != :followedId LIMIT 9")
    List<User> listUserUnFollowed(@Param("followedId") Long followedId);

    @Query("SELECT f.user FROM Follow f WHERE f.followedUser.id = :userId")
    List<User> listUserFollowed(@Param("userId") Long userId);

    @Query("SELECT f.followedUser FROM Follow f WHERE f.user.id = :userId")
    List<User> listUserFollowing(@Param("userId") Long userId);

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
