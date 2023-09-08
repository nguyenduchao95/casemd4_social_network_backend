package com.case_social_network.repository;

import com.case_social_network.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepo extends JpaRepository<User,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM users u WHERE u.id NOT IN (SELECT f.user_id FROM follow f WHERE f.follower_user_id = :followerId) AND u.id != :followerId LIMIT 9")
    List<User> listUserUnFollowed(@Param("followerId") Long followerId);

    @Query("SELECT f.user FROM Follow f WHERE f.followerUser.id = :userId")
    List<User> listUserFollowed(@Param("userId") Long userId);

    @Query("SELECT f.followerUser FROM Follow f WHERE f.user.id = :userId")
    List<User> listUserFollowing(@Param("userId") Long userId);
}
