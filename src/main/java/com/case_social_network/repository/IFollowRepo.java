package com.case_social_network.repository;
import com.case_social_network.entity.Follow;
import com.case_social_network.entity.Like;
import com.case_social_network.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IFollowRepo extends CrudRepository<Follow,Long> {
    @Query("SELECT f.user FROM Follow f WHERE f.follower_user.id = :userId")
    List<User> listUserFollowed(@Param("userId") Long userId);


    void delete(Follow follow);

    @Query("SELECT f FROM Follow f WHERE f.follower_user = :userFl AND f.user = :user")
    Follow checkFollowed(@Param("user") User user, @Param("userFl") User userFl);


    @Query("SELECT u FROM User u WHERE u.id NOT IN (SELECT f.user.id FROM Follow f WHERE f.follower_user.id = :followerId)")
    List<User> listUser(@Param("followerId") Long followerId);


}
