package com.example.fashionblog.Service;

import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.CommentLikesRequest;
import com.example.fashionblog.Model.PostLikesRequest;

public interface CommentLikesService {
    ApiResponse<String> likeComment(CommentLikesRequest commentLikesRequest);
    ApiResponse<String> unLikeComment(CommentLikesRequest commentLikesRequest);

    ApiResponse<String> countCommentLikes(CommentLikesRequest commentLikesRequest);
}
