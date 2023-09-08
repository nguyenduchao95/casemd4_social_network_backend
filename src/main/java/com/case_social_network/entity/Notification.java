package com.case_social_network.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "TEXT")
    private String message;
    private boolean read_status;
    private LocalDateTime created_at;
    @ManyToOne
    private User from_user;
    @ManyToOne
    private User to_user;
    @ManyToOne
    private Post post;
}
