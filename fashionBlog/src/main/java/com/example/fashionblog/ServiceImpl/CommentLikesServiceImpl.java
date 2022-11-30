package com.example.fashionblog.ServiceImpl;

import com.example.fashionblog.Entities.*;
import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.CommentLikesRequest;
import com.example.fashionblog.Repository.*;
import com.example.fashionblog.Service.CommentLikesService;
import com.example.fashionblog.Service.CommentService;
import com.example.fashionblog.Utils.ResponseManager;
import com.example.fashionblog.Utils.Status;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CommentLikesServiceImpl implements CommentLikesService {

    public final ResponseManager responseManager;
    public final CommentLikesEntityRepository commentLikesEntityRepository;
    public final CommentEntityRepository commentEntityRepository;
    public final CustomerEntityRepository customerEntityRepository;
    @Override
    public ApiResponse<String> likeComment(CommentLikesRequest commentLikesRequest) {
        CommentEntity commentToBeLiked = commentEntityRepository.getCommentEntityById(commentLikesRequest.getCommentId());
        CustomerEntity customerWhoLikeTheComment = customerEntityRepository.findCustomerEntityById(commentLikesRequest.getCustomerId());
        CommentLikesEntity newLikesForComment = new CommentLikesEntity();
        newLikesForComment.setCustomerEntity(customerWhoLikeTheComment);
        newLikesForComment.setCommentEntity(commentToBeLiked);
        newLikesForComment.setStatus(Status.LIKE);

        Boolean commentAlreadyLikedByCustomer = commentLikesEntityRepository.existsCommentLikesEntityByCustomerEntity_IdAndCommentEntity_Id
                (commentLikesRequest.getCustomerId(), commentLikesRequest.getCommentId());
        if (commentAlreadyLikedByCustomer)
            return responseManager.error("Comment already liked by you");
        commentLikesEntityRepository.save(newLikesForComment);
        return responseManager.success("Comment with id " + commentLikesRequest.getCommentId()
                + " liked by " + customerWhoLikeTheComment.getUsername());
    }

    @Override
    public ApiResponse<String> unLikeComment(CommentLikesRequest commentLikesRequest) {

        CommentLikesEntity existingCommentLikes = commentLikesEntityRepository.getCommentLikesEntityByCustomerEntity_IdAndCommentEntity_Id
                (commentLikesRequest.getCustomerId(),commentLikesRequest.getCommentId());
        Boolean commentAlreadyLikedByCustomer = commentLikesEntityRepository.existsCommentLikesEntityByCustomerEntity_IdAndCommentEntity_Id
                (commentLikesRequest.getCustomerId(), commentLikesRequest.getCommentId());
        if (commentAlreadyLikedByCustomer){
            commentLikesEntityRepository.delete(existingCommentLikes);
            return responseManager.success("You have unliked comment: " + commentLikesRequest.getCommentId());
        }

        return responseManager.error("You have to LIKE a comment before UNLIKING it");
    }

    @Override
    public ApiResponse<String> countCommentLikes(CommentLikesRequest commentLikesRequest) {
//        List<PostLikesEntity> allPostLikes = postLikesEntityRepository.findPostLikesEntitiesByPostEntity_Id(postLikesRequest.getPostId());
//        return responseManager.success("Likes: " + allPostLikes.size());
        List<CommentLikesEntity> allCommentLikes = commentLikesEntityRepository.findCommentLikesEntitiesByCommentEntity_Id
                (commentLikesRequest.getCommentId());
        return responseManager.success("Likes: " + allCommentLikes.size());
    }
}
