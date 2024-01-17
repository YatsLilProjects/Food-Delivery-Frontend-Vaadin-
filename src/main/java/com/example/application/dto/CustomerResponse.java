package com.example.application.dto;

import com.example.application.model.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CustomerResponse extends Response {

    private Customer customer;

    public CustomerResponse(boolean success, List<String> errMessage, String responseData, Customer customer) {
        super(success, errMessage, responseData);
        this.customer = customer;
    }
}
