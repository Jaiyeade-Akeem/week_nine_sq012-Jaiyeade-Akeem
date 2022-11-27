package com.example.fashionblog.Utils;

import com.example.fashionblog.Model.ApiResponse;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class ResponseManager<T> {

    public ApiResponse<T> success(T data){
        return new ApiResponse<T>("Request successful", true, data);
    }
    public ApiResponse<T> error(String errMessage){
        return new ApiResponse<>(errMessage, false, null);
    }
}
