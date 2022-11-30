package com.example.fashionblog.Controller;

import com.example.fashionblog.Entities.PostEntity;
import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.PostLikesRequest;
import com.example.fashionblog.Model.PostRequest;
import com.example.fashionblog.ServiceImpl.PostServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/fashion-blog/Post")
public class PostController {
    private PostServiceImpl postServiceImpl;

    @PostMapping("/create-post")
    public ApiResponse<PostEntity> createPost(@RequestBody PostRequest postRequest){
        return postServiceImpl.createPost(postRequest);
    }

    @GetMapping("/view-all-posts")
    public List<PostEntity> viewAllPost(){
        return postServiceImpl.viewAllPost();
    }

    @GetMapping("/view-post/{id}")
    public ApiResponse<PostEntity> viewAPost(@PathVariable("id") Long id){
        return postServiceImpl.viewAPost(id);
    }

    @DeleteMapping("/delete-post/{id}")
    public ApiResponse<String> deletePost(@PathVariable("id") Long id){
        return postServiceImpl.deletePost(id);
    }

    @PutMapping("/edit-post/{id}")
    public ApiResponse<PostEntity> updatePost(@PathVariable("id") Long id, @RequestBody PostRequest postRequest){
        return postServiceImpl.editPost(id, postRequest);
    }

}
