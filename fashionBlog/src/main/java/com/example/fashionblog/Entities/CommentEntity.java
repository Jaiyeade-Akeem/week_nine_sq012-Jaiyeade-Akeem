package com.example.fashionblog.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Data
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity postEntity;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String commentText;
    @CreationTimestamp
    private Timestamp createdAt;
    @Transient
    private Integer likes = 0;
}
