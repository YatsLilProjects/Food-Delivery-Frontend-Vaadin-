package com.example.application.service;


import com.example.application.dto.Response;
import com.example.application.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "customer-service", url = "${basicUrl}")
public interface CustomerService {

    @PostMapping("/addCustomer")
    Response<Customer> addCustomer(Customer customer);

    @GetMapping("/getCustomerById")
    Response<Customer> getCustomerById(@RequestParam int customerId);


}
