package com.example.fashionblog.ServiceImpl;

import com.example.fashionblog.Entities.PostEntity;
import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.PostRequest;
import com.example.fashionblog.Repository.PostEntityRepository;
import com.example.fashionblog.Service.PostService;
import com.example.fashionblog.Utils.ResponseManager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    public  final ResponseManager responseManager;
    public final PostEntityRepository postEntityRepository;
    @Override
    public ApiResponse<PostEntity> createPost(PostRequest postRequest) {

        if (postRequest.getCreatedBy().length() == 0 ||
            postRequest.getPostTitle().length() == 0 ||
            postRequest.getPostText().length() == 0)
            return responseManager.error("All fields are required!");
        PostEntity newPost = new PostEntity();
                newPost.setCreatedBy(postRequest.getCreatedBy());
                newPost.setPostTitle(postRequest.getPostTitle());
                newPost.setPostText(postRequest.getPostText());
                postEntityRepository.save(newPost);

                return responseManager.success(newPost);


    }

    @Override
    public List<PostEntity> viewAllPost() {

        return postEntityRepository.findAll();
    }

    @Override
    public ApiResponse<PostEntity> viewAPost( Long id) {
        PostEntity post = postEntityRepository.getPostEntityById(id);
        return responseManager.success(post);
    }

    @Override
    public List<PostEntity> searchPost(String keyword) {
        return null;
    }

    @Override
    public ApiResponse<String> deletePost(Long id) {

        boolean postExist = postEntityRepository.existsById(id);

        if (postExist){
            postEntityRepository.deleteById(id);
            return responseManager.success("post with the id: " + id + " successfully deleted!");
        }

        return responseManager.error("No record found for post with id: " + id);
    }

    @Override
    public ApiResponse<PostEntity> editPost(Long id, PostRequest postRequest) {
        boolean postExit = postEntityRepository.existsById(id);
        PostEntity postToBeEdited = new PostEntity();
        if (postExit){
            postToBeEdited = postEntityRepository.getPostEntityById(id);
            postToBeEdited.setCreatedBy(postToBeEdited.getCreatedBy());
            postToBeEdited.setPostTitle(postRequest.getPostTitle());
            postToBeEdited.setPostText(postRequest.getPostText());
            postEntityRepository.save(postToBeEdited);
            return responseManager.success(postToBeEdited);
        }
        return responseManager.error("No record found for post with id: " + id);
    }
}
