package com.example.application.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUp {
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_]{3,10}$"
            , message = "Username must consist of 3 to 10 alphanumeric characters or underscores (a-z, A-Z, 0-9, _)")
    private String username;

    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    private Customer customer;

}
