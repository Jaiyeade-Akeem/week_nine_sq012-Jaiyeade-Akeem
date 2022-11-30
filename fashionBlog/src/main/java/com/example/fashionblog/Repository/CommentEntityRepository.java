package com.example.fashionblog.Repository;

import com.example.fashionblog.Entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentEntityRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findCommentEntitiesByPostEntity_Id(Long id);
    CommentEntity findCommentEntityByCustomerEntityIdAndPostEntity_Id(Long customerId, Long postId);
    CommentEntity getCommentEntityById(Long id);
}