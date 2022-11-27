package com.example.fashionblog.Repository;

import com.example.fashionblog.Entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity findByEmailAndPassword(String email, String password);
    String deleteByEmail(String email);
    CustomerEntity findByEmail(String email);
    CustomerEntity findCustomerEntityById(Long id);
    Boolean existsByEmail(String email);
}