package com.example.fashionblog.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private String createdBy;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String postTitle;
    @Column(nullable = false, columnDefinition = "TEXT")
    private  String postText;

    @Transient
    private Integer likes = 0;

    @CreationTimestamp
    private Timestamp createdAt;

}
