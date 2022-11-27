package com.example.fashionblog.Model;

import com.example.fashionblog.Utils.Status;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.fashionblog.Entities.CommentLikesEntity} entity
 */
@Data
public class CommentLikesRequest implements Serializable {
    private Long customerId;
    private Long commentId;
    private Status status;
}