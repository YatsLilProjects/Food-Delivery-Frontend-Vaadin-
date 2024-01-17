package com.example.application.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

    private Integer customerId;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]{2,10}$", message = "Name should consist of 2 to 10 characters and contain only letters(a-z,A-Z)")
    private String customerName;

    @NotBlank
    @Pattern(regexp = "^\\d{10}$", message = "Contact number must be a 10-digit number")
    private String customerContactNo;

    @NotBlank
    @Email(message = "Invalid email id")
    private String customerEmailId;

    private CustomerAddress customerAddress;

    private SignUp signUp;

    private UserType userType;

}
