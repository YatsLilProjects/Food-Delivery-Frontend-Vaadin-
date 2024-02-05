package com.example.application.model;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodCart {

    private Integer cartId;

    private List<String> itemList;
    @Positive

    private double totalCost;
    private Customer customer;
    private Restaurant restaurant;

}
