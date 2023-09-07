package com.case_social_network.repository;
import com.case_social_network.entity.Follow;
import com.case_social_network.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IFollowRepo extends CrudRepository<Follow,Long> {
    @Query("SELECT f.user FROM Follow f WHERE f.follower_user.id = :userId")
    List<User> findUsersFollowingUserId(@Param("userId") Long userId);

}
