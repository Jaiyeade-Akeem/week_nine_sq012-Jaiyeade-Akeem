package com.example.fashionblog.Model;

import com.example.fashionblog.Utils.Status;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.fashionblog.Entities.PostLikesEntity} entity
 */
@Data
public class PostLikesRequest implements Serializable {
    private Long customerId;
    private Long postId;
    private Status status;
}