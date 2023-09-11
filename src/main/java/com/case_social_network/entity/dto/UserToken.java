package com.case_social_network.entity.dto;

import com.case_social_network.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserToken {
    private long id;
    private String firstName;
    private String lastName;
    private boolean gender;
    private String username;
    private String email;
    private String image;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String token;
    private List<Role> roles;

    public UserToken(String token) {
        this.token = token;
    }

    public UserToken(String email, String token) {
        this.email = email;
        this.token = token;
    }
}
