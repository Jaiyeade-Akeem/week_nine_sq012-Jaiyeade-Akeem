package com.example.fashionblog.Repository;

import com.example.fashionblog.Entities.CommentLikesEntity;
import com.example.fashionblog.Entities.PostLikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentLikesEntityRepository extends JpaRepository<CommentLikesEntity, Long> {
    Boolean existsCommentLikesEntityByCustomerEntity_IdAndCommentEntity_Id(Long customerId, Long commentId);
    CommentLikesEntity getCommentLikesEntityByCustomerEntity_IdAndCommentEntity_Id(Long customerId, Long commentId);
    List<CommentLikesEntity> findCommentLikesEntitiesByCommentEntity_Id(Long commentId);
}