package com.example.application.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Order {

    private Integer orderId;
    private Customer customer;
    private Restaurant restaurant;
    private Double totalCost;
    private LocalDateTime orderDate;
    private List<String> specialInstructions;
    private List<String> itemList;
    private List<Integer> menuItemPriceList;


}
