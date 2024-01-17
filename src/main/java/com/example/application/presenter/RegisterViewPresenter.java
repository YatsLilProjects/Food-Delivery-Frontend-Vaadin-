package com.example.application.presenter;

import com.example.application.dto.Response;
import com.example.application.model.Customer;
import com.example.application.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterViewPresenter {

    @Autowired
    CustomerService customerService;

    public Response<Customer> addCustomer(Customer customer)
    {
        return customerService.addCustomer(customer);
    }


}
