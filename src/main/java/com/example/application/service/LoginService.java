package com.example.application.service;


import com.example.application.dto.CustomerResponse;
import com.example.application.model.Customer;
import com.example.application.model.LogIn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="login-service",url = "${publicUrl}")
public interface LoginService {

    @PostMapping("/login")
    public CustomerResponse loginCustomer(LogIn logIn);


}
