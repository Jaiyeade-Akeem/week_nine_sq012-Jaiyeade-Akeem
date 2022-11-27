package com.example.fashionblog.Entities;

import com.example.fashionblog.Utils.Status;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CommentLikesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private CommentEntity commentEntity;
    @Enumerated(EnumType.STRING)
    private Status status;
}
