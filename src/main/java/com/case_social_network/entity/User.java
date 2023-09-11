package com.case_social_network.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    public User(String firstName, String lastName, boolean gender, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public User(String firstName, String lastName, boolean gender, String email, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.username = username;
    }
}
