package com.case_social_network.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
    private String email;
    private String password;
    @Column(columnDefinition = "TEXT")
    private String image;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
