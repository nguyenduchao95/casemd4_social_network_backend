package com.case_social_network.service.impl;

import com.case_social_network.configSercurity.reset_password.UserNotFoundException;
import com.case_social_network.entity.User;
import com.case_social_network.repository.IUserRepo;
import com.case_social_network.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepo userRepo;

    @Override
    public void delete(long id) {

    }

    @Override
    public User findById(long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<User> findByStr(String name) {
        return null;
    }


    @Override
    public List<User> listUserFollowed(Long userId) {
        return userRepo.listUserFollowed(userId);
    }

    @Override
    public List<User> listUserUnFollowed(Long userFlId) {
        return userRepo.listUserUnFollowed(userFlId);
    }

    @Override
    public List<User> listUserFollowing(Long userId) {
        return userRepo.listUserFollowing(userId);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public void edit(User user) {
        userRepo.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User getUser(String username, String password) { // login ok
        return userRepo.checkUser(username, password);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }


    @Override
    public User findUserById(long id) {
        return userRepo.findUserById(id);
    }

    // hàm loadUserByUsername trả về UserDetails
// nên sẽ return về User ( User này có trong spring boost mà ko phải là User m chúng ta tạo trong Entity
// Nếu trong Entity tạo là User thì khi trả về UserDetails phải gắn đường dẫn của User trong Spring boost để trả về đúng đối tượng
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getRoles());
    }

    // check email ton tai trong db ung vs username thi ms gui token
    public void updateResetPassword(String token, String email) throws UserNotFoundException {
        // kiem tra user bang email
        User user = userRepo.findUserByEmail(email);
        // neu user ton tai thi luu ResetPasswordToken vao DB
        if (user != null) {
            user.setResetPasswordToken(token);
            userRepo.save(user);
        } else {
            throw new UserNotFoundException("Could not found any user with email : " + email);
        }
    }

    // kiem tra xem ResetPasswordToken co thuoc ve user do khong
    public User getByResetPasswordToken(String resetPasswordToken) {
        return userRepo.findUserByResetPasswordToken(resetPasswordToken);
    }

    public void updatePassword(User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodePassword);
        user.setResetPasswordToken(newPassword);
        userRepo.save(user);
    }
}
