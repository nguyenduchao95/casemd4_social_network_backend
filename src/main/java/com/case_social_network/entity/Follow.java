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
    private User followedUser;
    @ManyToOne
    private User user;

    public Follow(User followedUser, User user) {
        this.followedUser = followedUser;
        this.user = user;
    }
}
