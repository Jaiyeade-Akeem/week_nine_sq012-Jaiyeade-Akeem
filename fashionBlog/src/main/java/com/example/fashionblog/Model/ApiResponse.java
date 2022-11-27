package com.example.fashionblog.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private String message;
    private boolean status;
    private T data;
}
