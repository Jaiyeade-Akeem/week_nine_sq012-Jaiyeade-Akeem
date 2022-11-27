package com.example.fashionblog.Repository;

import com.example.fashionblog.Entities.PostLikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikesEntityRepository extends JpaRepository<PostLikesEntity, Long> {
}