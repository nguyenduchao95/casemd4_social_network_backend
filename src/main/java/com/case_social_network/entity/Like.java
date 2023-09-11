package com.case_social_network.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Post post;

    public Like(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public Like() {
    }
}

