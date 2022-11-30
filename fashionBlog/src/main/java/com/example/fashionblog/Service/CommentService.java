package com.example.fashionblog.Service;

import com.example.fashionblog.Entities.CommentEntity;
import com.example.fashionblog.Entities.PostEntity;
import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.CommentRequest;

import java.util.List;

public interface CommentService {
    ApiResponse<CommentEntity> createComment(CommentRequest commentRequest);
    List<CommentEntity> viewAllComment(Long id);
    ApiResponse<String> deleteComment(CommentRequest commentRequest);
    ApiResponse<CommentEntity> editComment(CommentRequest commentRequest);
}
