package com.case_social_network.service;

import com.case_social_network.configSercurity.reset_password.UserNotFoundException;
import com.case_social_network.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends IService<User>, UserDetailsService {
    List<User> listUserFollowed(Long userId);

    List<User> listUserUnFollowed(Long userFlId);

    List<User> listUserFollowing(Long userId);

    User findByUsername(String username);

    void edit(User user);

    User getUser(String username, String password);

    User findByUsernameAndPassword(String username, String password);

    User findUserById(long id);

    void updateResetPassword(String token, String username) throws UserNotFoundException;

    User findByEmail(String email);

    User getByResetPasswordToken(String token);

    void updatePassword(User user, String newPassword);

}
