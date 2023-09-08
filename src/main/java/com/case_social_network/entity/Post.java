package com.case_social_network.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "TEXT")
    private String img;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime created_at;
    @ManyToOne
    private User user;
}
