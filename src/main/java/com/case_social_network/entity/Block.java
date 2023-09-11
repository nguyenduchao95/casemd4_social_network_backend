package com.case_social_network.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User blockUser;
    @ManyToOne
    private User user;

    public Block(User blockUser, User user) {
        this.blockUser = blockUser;
        this.user = user;
    }
}
