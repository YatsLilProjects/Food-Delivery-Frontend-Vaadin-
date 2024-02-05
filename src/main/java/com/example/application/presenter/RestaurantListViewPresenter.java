package com.example.application.presenter;


import com.example.application.dto.Response;
import com.example.application.model.Restaurant;
import com.example.application.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantListViewPresenter {

    @Autowired
    private RestaurantService restaurantService;

    public Response<List<Restaurant>> findRestaurantsByMenuItemName(String itemName) {
        return restaurantService.findRestaurantsByMenuItemName(itemName);
    }


}
