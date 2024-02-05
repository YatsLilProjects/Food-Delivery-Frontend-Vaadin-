package com.example.application.presenter;

import com.example.application.dto.Response;
import com.example.application.model.FoodType;
import com.example.application.model.TopBrands;
import com.example.application.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HomeViewPresenter {

    @Autowired
    private RestaurantService restaurantService;

    public Response<List<FoodType>> viewAllFoodTypes() {
       return restaurantService.viewAllFoodTypes();
    }

    public Response<List<TopBrands>> viewAllTopBrands() {
        return restaurantService.viewAllTopBrands();
    }





}
