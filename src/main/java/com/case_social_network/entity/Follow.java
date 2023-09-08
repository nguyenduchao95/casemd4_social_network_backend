package com.case_social_network.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User followerUser;
    @ManyToOne
    private User user;

    public Follow(User followerUser, User user) {
        this.followerUser = followerUser;
        this.user = user;
    }
}
