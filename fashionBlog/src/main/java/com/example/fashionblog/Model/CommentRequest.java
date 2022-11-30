package com.example.fashionblog.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.fashionblog.Entities.CommentEntity} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest implements Serializable {
    private Long customerId;
    private Long postId;
    private String commentText;

    public CommentRequest(Long customerId, Long postId) {
        this.customerId = customerId;
        this.postId = postId;
    }
}