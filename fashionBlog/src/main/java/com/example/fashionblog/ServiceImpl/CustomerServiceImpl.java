package com.example.fashionblog.ServiceImpl;

import com.example.fashionblog.Entities.CustomerEntity;
import com.example.fashionblog.Entities.PostEntity;
import com.example.fashionblog.Model.ApiResponse;
import com.example.fashionblog.Model.CustomerRequest;
import com.example.fashionblog.Repository.CustomerEntityRepository;
import com.example.fashionblog.Repository.PostEntityRepository;
import com.example.fashionblog.Service.CustomerService;
import com.example.fashionblog.Utils.ResponseManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    public final ResponseManager responseManager;
    public final CustomerEntityRepository customerEntityRepository;
    public final PostEntityRepository postEntityRepository;
    @Override
    public ApiResponse createAccount(CustomerRequest customerRequest) {

        if(customerRequest.getUsername().length() == 0 ||
           customerRequest.getEmail().length() == 0 ||
           customerRequest.getPassword().length() == 0)
            return responseManager.error("All fields required");

        CustomerEntity newCustomer = new CustomerEntity();
        newCustomer.setUsername(customerRequest.getUsername());
        newCustomer.setEmail(customerRequest.getEmail());
        newCustomer.setPassword(customerRequest.getPassword());
        Boolean existingCustomer = customerEntityRepository.existsByEmail(customerRequest.getEmail());
        if (existingCustomer)
            return responseManager.error("You have already registered!");
        customerEntityRepository.save(newCustomer);

        return responseManager.success(newCustomer);

    }

    @Override
    public List login(CustomerRequest customerRequest) {
            if(customerRequest.getEmail().length() == 0 || customerRequest.getPassword().length() == 0){
                return Collections.singletonList(("Email and Password required!"));
        }
        CustomerEntity existingCustomer = customerEntityRepository
                .findByEmailAndPassword(customerRequest.getEmail(), customerRequest.getPassword());

            if (existingCustomer == null){
                return Collections.singletonList(("Login failed. Please enter correct username and password"));
        }

        return postEntityRepository.findAll();



    }

    @Override
    public ApiResponse<String> deleteAccount(CustomerRequest customerRequest) {
        Boolean customerExist = customerEntityRepository.existsByEmail(customerRequest.getEmail());
        if (customerExist){
            CustomerEntity en = customerEntityRepository.findByEmail(customerRequest.getEmail());
            customerEntityRepository.deleteById(en.getId());
            return responseManager.success("Account successfully deleted!");
                }

        return responseManager.error("Account with email: " + customerRequest.getEmail() + " does not exist");
   }
}
