package com.example.fashionblog.Model;

import com.example.fashionblog.Entities.PostEntity;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link PostEntity} entity
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest implements Serializable {
    private String createdBy;
    private String postTitle;
    private String postText;
}