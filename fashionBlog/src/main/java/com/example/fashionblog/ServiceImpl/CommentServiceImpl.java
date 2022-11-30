package com.example.fashionblog.ServiceImpl;

import com.example.fashionblog.Entities.CommentEntity;
import com.example.fashionblog.Entities.CustomerEntity;
import com.example.fashionblog.Entities.PostEntity;
import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.CommentRequest;
import com.example.fashionblog.Model.PostRequest;
import com.example.fashionblog.Repository.CommentEntityRepository;
import com.example.fashionblog.Repository.CustomerEntityRepository;
import com.example.fashionblog.Repository.PostEntityRepository;
import com.example.fashionblog.Service.CommentService;
import com.example.fashionblog.Utils.ResponseManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    public final CommentEntityRepository commentEntityRepository;
    public final CustomerEntityRepository customerEntityRepository;
    public final PostEntityRepository postEntityRepository;
    public final ResponseManager responseManager;
    @Override
    public ApiResponse<CommentEntity> createComment(CommentRequest commentRequest) {
        if (commentRequest.getCustomerId() == 0 ||
                commentRequest.getPostId() == 0 ||
                commentRequest.getCommentText().length() == 0)
            return responseManager.error("All fields required");

        CommentEntity newComment = new CommentEntity();
        newComment.setCustomerEntity(customerEntityRepository
                .findCustomerEntityById(commentRequest.getCustomerId()));
        newComment.setPostEntity(postEntityRepository
                .getPostEntityById(commentRequest.getPostId()));
        newComment.setCommentText(commentRequest.getCommentText());
        commentEntityRepository.save(newComment);

        return responseManager.success("New comment on post with id: "
                + newComment.getPostEntity().getId() + " successfully created!");
    }

    @Override
    public List<CommentEntity> viewAllComment(Long postId) {

        return commentEntityRepository.findCommentEntitiesByPostEntity_Id(postId);
    }

    @Override
    public ApiResponse<String> deleteComment(CommentRequest commentRequest) {
        CommentEntity commentToBeDeleted = commentEntityRepository.findCommentEntityByCustomerEntityIdAndPostEntity_Id
                (commentRequest.getCustomerId(), commentRequest.getPostId());
        commentEntityRepository.delete(commentToBeDeleted);
        return responseManager.success("Comment made by customer with "
                + commentRequest.getCustomerId() + " on post " + commentRequest.getPostId() + " deleted" );
    }

    @Override
    public ApiResponse<CommentEntity> editComment(CommentRequest commentRequest) {
        CommentEntity commentToBeUpdated = commentEntityRepository.findCommentEntityByCustomerEntityIdAndPostEntity_Id
                (commentRequest.getCustomerId(), commentRequest.getPostId());
        commentToBeUpdated.setCommentText(commentRequest.getCommentText());
        commentEntityRepository.save(commentToBeUpdated);

        return responseManager.success(commentToBeUpdated);
    }
}
