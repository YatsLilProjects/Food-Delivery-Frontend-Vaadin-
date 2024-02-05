package com.example.application.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
public class Restaurant {

    private Integer restaurantId;

    @NotBlank(message = "Restaurant name required")
    @Pattern(regexp = "^[a-zA-Z0-9\\s-_',]{2,}$", message = "Restaurant name should consist of at least 2 alphanumeric characters, spaces, hyphens,commas or underscores")
    private String restaurantName;

    @NotBlank(message = "Restaurant contact number required")
    @Pattern(regexp = "^\\d{10}$", message = "Contact number must be a 10-digit number")
    private String restaurantContactNo;

    @NotBlank(message = "Restaurant location required")
    @Pattern(regexp = "^[a-zA-Z0-9\\s-]*$", message = "Location should consist of alphanumeric characters or hyphens (a-z, A-Z, 0-9,-)")
    private String restaurantLocation;

    private String restaurantImage;

    private List<CuisineTypeData> cuisineTypeData;

    private List<MenuItem> menuItems;

//    private List<Rating> ratings;

    private List<Order> orders;

    private List<FoodCart> foodCart;


}

