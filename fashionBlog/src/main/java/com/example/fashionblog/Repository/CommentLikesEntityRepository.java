package com.example.fashionblog.Repository;

import com.example.fashionblog.Entities.CommentLikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentLikesEntityRepository extends JpaRepository<CommentLikesEntity, Long> {
}