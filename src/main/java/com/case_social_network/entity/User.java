package com.case_social_network.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

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
    private Timestamp created_at;
    private Timestamp updated_at;
}
