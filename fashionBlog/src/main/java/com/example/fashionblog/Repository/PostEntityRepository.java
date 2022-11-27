package com.example.fashionblog.Repository;

import com.example.fashionblog.Entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostEntityRepository extends JpaRepository<PostEntity, Long> {
    PostEntity getPostEntityById(Long id);
}