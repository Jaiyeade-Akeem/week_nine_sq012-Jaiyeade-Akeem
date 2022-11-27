package com.example.fashionblog.Controller;

import com.example.fashionblog.Entities.CommentEntity;
import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.CommentRequest;
import com.example.fashionblog.ServiceImpl.CommentServiceImpl;
import com.example.fashionblog.ServiceImpl.CustomerServiceImpl;
import com.example.fashionblog.ServiceImpl.PostServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/fashion-blog/comment")
public class CommentController {
    private PostServiceImpl postService;
    private CommentServiceImpl commentService;
    private CustomerServiceImpl customerService;
    @PostMapping("/create-comment")
    public ApiResponse<CommentEntity> createComment(@RequestBody CommentRequest commentRequest){
        return commentService.createComment(commentRequest);
    }
}
