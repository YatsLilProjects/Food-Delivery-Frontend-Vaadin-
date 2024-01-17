package com.example.application.service;


import com.example.application.dto.Response;
import com.example.application.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="customer-service",url = "${basicUrl}")
public interface CustomerService {

    @PostMapping("/addCustomer")
    public Response<Customer> addCustomer(Customer customer);


}
