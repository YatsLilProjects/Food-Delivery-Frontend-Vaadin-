package com.example.application.presenter;

import com.example.application.dto.Response;
import com.example.application.model.Customer;
import com.example.application.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogoutViewPresenter {
    @Autowired
    private CustomerService customerService;

    public Response<Customer> getCustomerById(int customerId) {
        return customerService.getCustomerById(customerId);
    }
}
