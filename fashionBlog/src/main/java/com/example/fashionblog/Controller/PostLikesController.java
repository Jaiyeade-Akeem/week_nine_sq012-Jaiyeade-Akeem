package com.example.fashionblog.Controller;

import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.PostLikesRequest;
import com.example.fashionblog.ServiceImpl.PostLikesServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/fashion-blog/like-post")
public class PostLikesController {
    private PostLikesServiceImpl postLikesService;

    @PostMapping("/like")
    ApiResponse<String> like_post(@RequestBody PostLikesRequest postLikesRequest){
        return postLikesService.likePost(postLikesRequest);
    }
    @DeleteMapping("/unlike")
    ApiResponse<String> unlike_post(@RequestBody PostLikesRequest postLikesRequest){
        return postLikesService.unLikePost(postLikesRequest);
    }
    @GetMapping("/number-of-post-likes")
    ApiResponse<String> postLikeCount(@RequestBody PostLikesRequest postLikesRequest){
        return postLikesService.countPostLikes(postLikesRequest);
    }
}
