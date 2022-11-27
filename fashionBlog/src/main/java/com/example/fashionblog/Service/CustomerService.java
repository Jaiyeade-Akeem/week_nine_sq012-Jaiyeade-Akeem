package com.example.fashionblog.Service;

import com.example.fashionblog.Entities.CustomerEntity;
import com.example.fashionblog.Entities.PostEntity;
import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.CustomerRequest;

import java.util.List;

public interface CustomerService {
    ApiResponse createAccount(CustomerRequest customerRequest);
    List login(CustomerRequest customerRequest);
    ApiResponse<String> deleteAccount(CustomerRequest customerRequest);
}
