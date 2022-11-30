package com.example.fashionblog.Controller;

import com.example.fashionblog.Entities.CommentEntity;
import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.CommentRequest;
import com.example.fashionblog.ServiceImpl.CommentServiceImpl;
import com.example.fashionblog.ServiceImpl.CustomerServiceImpl;
import com.example.fashionblog.ServiceImpl.PostServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/view-all-comment/{postId}")
    public List<CommentEntity> view_all_comment_of_a_post(@PathVariable Long postId){
        return commentService.viewAllComment(postId);
    }

    @DeleteMapping("/delete")
    public ApiResponse<String> delete_comment(@RequestBody CommentRequest commentRequest){
        return commentService.deleteComment(commentRequest);
    }

    @PutMapping("/edit-comment")
    public ApiResponse<CommentEntity> update(@RequestBody CommentRequest commentRequest){
        return commentService.editComment(commentRequest);
    }
}
