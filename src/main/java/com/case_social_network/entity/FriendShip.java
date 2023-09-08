package com.case_social_network.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FriendShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user1;
    @ManyToOne
    private User user2;
    private String status; // Pending, Accepted, Declined

}
