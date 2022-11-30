package com.example.fashionblog.Repository;

import com.example.fashionblog.Entities.PostLikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostLikesEntityRepository extends JpaRepository<PostLikesEntity, Long> {
    Boolean existsPostLikesEntityByCustomerEntity_IdAndPostEntity_Id(Long customerId, Long postId);
    PostLikesEntity getPostLikesEntityByCustomerEntity_IdAndPostEntity_Id(Long customerId, Long postId);
    List<PostLikesEntity> findPostLikesEntitiesByPostEntity_Id(Long postId);
}