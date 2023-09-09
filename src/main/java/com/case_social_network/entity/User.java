package com.case_social_network.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private boolean gender;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(columnDefinition = "TEXT")
    private String image;
    private LocalDate created_at;
    private LocalDate updated_at;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    public User() {
    }

    public User(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }


}
