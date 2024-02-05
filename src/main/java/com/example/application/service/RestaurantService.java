package com.example.application.service;


import com.example.application.dto.Response;
import com.example.application.model.FoodType;
import com.example.application.model.Restaurant;
import com.example.application.model.TopBrands;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "restaurant-service", url = "${basicUrl}")
public interface RestaurantService {

    @GetMapping("/viewAllFoodTypes")
    Response<List<FoodType>> viewAllFoodTypes();

    @GetMapping("/viewAllTopBrands")
    Response<List<TopBrands>> viewAllTopBrands();

    @GetMapping("/restaurantsByMenuItemName/{itemName}")
    Response<List<Restaurant>> findRestaurantsByMenuItemName(@PathVariable String itemName);

    @GetMapping("/viewRestaurantById")
    Response<Restaurant> findRestaurantById(@RequestParam Integer restaurantId);

    @GetMapping("/viewAllRestaurants")
    Response<List<Restaurant>> viewAllRestaurants();

}
