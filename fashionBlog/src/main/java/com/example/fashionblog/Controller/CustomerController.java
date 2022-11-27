package com.example.fashionblog.Controller;

import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.CustomerRequest;
import com.example.fashionblog.ServiceImpl.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@RestController
@RequestMapping("api/v1/fashion-blog/customer")
public class CustomerController {
    private CustomerServiceImpl customerServiceImpl;

    @PostMapping("/sign-up")
    public ApiResponse createAccount(@RequestBody CustomerRequest customerRequest){
        return customerServiceImpl.createAccount(customerRequest);
    }
    @PostMapping("/login")
    public List login(@RequestBody CustomerRequest customerRequest){
       return customerServiceImpl.login(customerRequest);
    }
    @DeleteMapping("/delete-account")
    public ApiResponse<String> deleteAccount(@RequestBody CustomerRequest customerRequest){
       return customerServiceImpl.deleteAccount(customerRequest);
    }
}
