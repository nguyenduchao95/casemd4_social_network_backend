package com.case_social_network.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User follower_user;
    @ManyToOne
    private User user;

    public Follow() {
    }

    public Follow(User follower_user, User user) {
        this.follower_user = follower_user;
        this.user = user;
    }
}
