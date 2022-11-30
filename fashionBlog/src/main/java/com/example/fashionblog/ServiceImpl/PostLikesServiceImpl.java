package com.example.fashionblog.ServiceImpl;

import com.example.fashionblog.Entities.CustomerEntity;
import com.example.fashionblog.Entities.PostEntity;
import com.example.fashionblog.Entities.PostLikesEntity;
import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.PostLikesRequest;
import com.example.fashionblog.Repository.CustomerEntityRepository;
import com.example.fashionblog.Repository.PostEntityRepository;
import com.example.fashionblog.Repository.PostLikesEntityRepository;
import com.example.fashionblog.Service.PostLikesService;
import com.example.fashionblog.Utils.ResponseManager;
import com.example.fashionblog.Utils.Status;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PostLikesServiceImpl implements PostLikesService {

    public final ResponseManager responseManager;
    public final PostLikesEntityRepository postLikesEntityRepository;
    public final PostEntityRepository postEntityRepository;
    public final CustomerEntityRepository customerEntityRepository;
    @Override
    public ApiResponse<String> likePost(PostLikesRequest postLikesRequest) {
        PostEntity postToBeLiked = postEntityRepository.getPostEntityById(postLikesRequest.getPostId());
        CustomerEntity customerWhoLikedThePost = customerEntityRepository.findCustomerEntityById(postLikesRequest.getCustomerId());
        PostLikesEntity newLikesForPost = new PostLikesEntity();
        newLikesForPost.setPostEntity(postToBeLiked);
        newLikesForPost.setCustomerEntity(customerWhoLikedThePost);
        newLikesForPost.setStatus(Status.LIKE);
         Boolean postAlreadyLikedByCustomer = postLikesEntityRepository.existsPostLikesEntityByCustomerEntity_IdAndPostEntity_Id
                 (postLikesRequest.getCustomerId(), postLikesRequest.getPostId());
         if (postAlreadyLikedByCustomer)
             return responseManager.error("Post already liked by you");
         postLikesEntityRepository.save(newLikesForPost);
         return responseManager.success("Post with id: " + postLikesRequest.getPostId()
                 + " liked by " + customerWhoLikedThePost.getUsername());
    }

    @Override
    public ApiResponse<String> unLikePost(PostLikesRequest postLikesRequest) {
        PostLikesEntity exitingPostLikes = postLikesEntityRepository.getPostLikesEntityByCustomerEntity_IdAndPostEntity_Id
                (postLikesRequest.getCustomerId(), postLikesRequest.getPostId());
        Boolean postAlreadyLikedByCustomer = postLikesEntityRepository.existsPostLikesEntityByCustomerEntity_IdAndPostEntity_Id
                (postLikesRequest.getCustomerId(), postLikesRequest.getPostId());
        if (postAlreadyLikedByCustomer){
            postLikesEntityRepository.delete(exitingPostLikes);
            return  responseManager.success("you have unliked post: " + postLikesRequest.getPostId());
        }

        return responseManager.error("You have to LIKE a post before UNLIKING it");


    }

    @Override
    public ApiResponse<String> countPostLikes(PostLikesRequest postLikesRequest) {
        List<PostLikesEntity> allPostLikes = postLikesEntityRepository.findPostLikesEntitiesByPostEntity_Id(postLikesRequest.getPostId());
        return responseManager.success("Likes: " + allPostLikes.size());
    }
}
