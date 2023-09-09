package com.case_social_network.service;

import com.case_social_network.configSercurity.reset_password.UserNotFoundException;
import com.case_social_network.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public interface IUserService  extends UserDetailsService {
    List<User> getAll();

    void save(User user);

    void edit(User user);

    User findByUsername(String username);

    User getUser( String username , String password);

    User findByUsernameAndPassword ( String username ,String password);

    User findUserById(long id);

    void updateResetPassword(String token , String username) throws UserNotFoundException;

    User findByEmail(String email);

    User getByResetPasswordToken(String token);

    public void updatePassword(User user , String newPassword);


}
