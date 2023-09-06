package com.case_social_network.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User block_user;
    @ManyToOne
    private User user;
}
