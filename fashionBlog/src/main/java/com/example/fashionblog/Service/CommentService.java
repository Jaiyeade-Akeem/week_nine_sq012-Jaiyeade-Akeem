package com.example.fashionblog.Service;

import com.example.fashionblog.Entities.CommentEntity;
import com.example.fashionblog.Entities.PostEntity;
import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.CommentRequest;

import java.util.List;

public interface CommentService {
    ApiResponse<CommentEntity> createComment(CommentRequest commentRequest);
    List<CommentEntity> viewAllComment(PostEntity postEntity);
    ApiResponse<String> deleteComment(Long id);
    ApiResponse<CommentEntity> editComment(Long id);
}
