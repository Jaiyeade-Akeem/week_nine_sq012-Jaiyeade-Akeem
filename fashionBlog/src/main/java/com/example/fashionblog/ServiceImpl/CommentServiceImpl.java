package com.example.fashionblog.ServiceImpl;

import com.example.fashionblog.Entities.CommentEntity;
import com.example.fashionblog.Entities.CustomerEntity;
import com.example.fashionblog.Entities.PostEntity;
import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.CommentRequest;
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
        if (commentRequest.getCustomerId() == 0 || commentRequest.getPostId() == 0 || commentRequest.getCommentText().length() == 0)
            return responseManager.error("All fields required");
        CommentEntity newComment = new CommentEntity();
        newComment.setCustomerEntity(customerEntityRepository.findCustomerEntityById(commentRequest.getCustomerId()));
        newComment.setPostEntity(postEntityRepository.getPostEntityById(commentRequest.getPostId()));
        newComment.setCommentText(commentRequest.getCommentText());
        commentEntityRepository.save(newComment);
        PostEntity post = postEntityRepository.getPostEntityById(commentRequest.getPostId());
        post.getComments().add(newComment);
        postEntityRepository.save(post);

        return responseManager.success("New comment on post with id: " + newComment.getPostEntity().getId() + " successfully created!");
    }

    @Override
    public List<CommentEntity> viewAllComment(PostEntity postEntity) {
        return null;
    }

    @Override
    public ApiResponse<String> deleteComment(Long id) {
        return null;
    }

    @Override
    public ApiResponse<CommentEntity> editComment(Long id) {
        return null;
    }
}
