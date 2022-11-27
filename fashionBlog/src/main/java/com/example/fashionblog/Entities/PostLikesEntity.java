package com.example.fashionblog.Entities;

import com.example.fashionblog.Utils.Status;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PostLikesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity postEntity;

    @Enumerated(EnumType.STRING)
    private Status status;
}
