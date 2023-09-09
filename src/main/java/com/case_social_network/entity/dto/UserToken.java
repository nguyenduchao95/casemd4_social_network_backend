package com.case_social_network.entity.dto;

import com.case_social_network.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class UserToken {

    private long id;
    private String firstName;
    private String lastName;
    private boolean gender;
    private String username;
    private String email;
    private String image;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String token;
    private List<Role> roles;

    public UserToken() {
    }

    public UserToken( String token) {

        this.token = token;
    }

    public UserToken( String email   , String token) {
        this.email = email;
        this.token = token;
    }
}
