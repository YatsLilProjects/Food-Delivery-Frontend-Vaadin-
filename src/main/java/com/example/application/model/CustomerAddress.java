package com.example.application.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddress {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z\\s-]{2,10}$", message = "City should consist of 2 to 10 characters or hyphens(a-z,A-Z,-)")
    private String customerCity;

    @Pattern(regexp = "^[a-zA-Z0-9\\s-]*$", message = "Street should consist of alphanumeric characters or hyphens (a-z, A-Z, 0-9,-)")
    private String customerStreet;

    @NotBlank
    @Pattern(regexp = "^\\d{6}$", message = "PIN code must be a 6 digit number")
    private String customerPinCode;

}
