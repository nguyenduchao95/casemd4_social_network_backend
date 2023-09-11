package com.case_social_network.entity;
import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "TEXT")
    private String comment;
    private LocalDateTime created_at;
    @ManyToOne
    private User user;
    @ManyToOne
    private Post post;
}
