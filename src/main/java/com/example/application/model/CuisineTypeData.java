package com.example.application.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CuisineTypeData {

    private Integer cuisineId;
    @NotBlank(message = "Cuisine type required")
    private String cuisineType;
    List<Restaurant> restaurants;

}
