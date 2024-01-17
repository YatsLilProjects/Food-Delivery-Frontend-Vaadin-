package com.example.application.presenter;

import com.example.application.dto.CustomerResponse;
import com.example.application.model.LogIn;
import com.example.application.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginViewPresenter {

    @Autowired
    LoginService loginService;

    public CustomerResponse loginCustomer(LogIn logIn)
    {
        return loginService.loginCustomer(logIn);
    }



}
