package com.example.fashionblog.ServiceImpl;

import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.CommentLikesRequest;
import com.example.fashionblog.Service.CommentLikesService;
import com.example.fashionblog.Service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentLikesServiceImpl implements CommentLikesService {
    @Override
    public ApiResponse<String> likeComment(CommentLikesRequest commentLikesRequest) {
        return null;
    }

    @Override
    public ApiResponse<String> unLikeComment(CommentLikesRequest commentLikesRequest) {
        return null;
    }
}
