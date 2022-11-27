package com.example.fashionblog.Model;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.fashionblog.Entities.CommentEntity} entity
 */
@Data
public class CommentRequest implements Serializable {
    private Long customerId;
    private Long postId;
    private String commentText;
}