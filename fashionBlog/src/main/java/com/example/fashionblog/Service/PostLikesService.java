package com.example.fashionblog.Service;

import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.PostLikesRequest;

public interface PostLikesService {
    ApiResponse<String> likePost(PostLikesRequest postLikesRequest);
    ApiResponse<String> unLikePost(PostLikesRequest postLikesRequest);
    ApiResponse<String> countPostLikes(PostLikesRequest postLikesRequest);
}
