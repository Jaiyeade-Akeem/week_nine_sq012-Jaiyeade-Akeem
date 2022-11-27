package com.example.fashionblog.ServiceImpl;

import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.PostLikesRequest;
import com.example.fashionblog.Service.PostLikesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PostLIkesServiceImpl implements PostLikesService {
    @Override
    public ApiResponse<String> likePost(PostLikesRequest postLikesRequest) {
        return null;
    }

    @Override
    public ApiResponse<String> unLikePost(PostLikesRequest postLikesRequest) {
        return null;
    }
}
