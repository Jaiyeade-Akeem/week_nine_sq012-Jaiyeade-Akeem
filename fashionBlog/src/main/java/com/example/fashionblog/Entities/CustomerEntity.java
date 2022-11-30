package com.example.fashionblog.Entities;

import jakarta.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;


}
