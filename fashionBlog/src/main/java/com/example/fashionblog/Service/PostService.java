package com.example.fashionblog.Service;

import com.example.fashionblog.Entities.PostEntity;
import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.PostRequest;

import java.util.List;

public interface PostService {
    ApiResponse<PostEntity> createPost(PostRequest postRequest);
    List<PostEntity> viewAllPost();
    ApiResponse<PostEntity> viewAPost(Long id);
    List<PostEntity> searchPost(String keyword);
    ApiResponse<String> deletePost(Long id);
    ApiResponse<PostEntity> editPost(Long id, PostRequest postRequest);

}
