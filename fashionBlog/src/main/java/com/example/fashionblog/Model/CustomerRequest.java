package com.example.fashionblog.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.fashionblog.Entities.CustomerEntity} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomerRequest implements Serializable {
    private String username;
    private String email;
    private String password;

    public CustomerRequest(String email){
        this.email = email;
    }
    public CustomerRequest(String email, String password){
        this.email = email;
        this.password = password;
    }

}