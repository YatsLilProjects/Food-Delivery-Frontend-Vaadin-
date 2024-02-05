package com.example.application.views.forms;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Route(value = "restaurants", layout = CustomerHeaderView.class)
@Slf4j
public class RestaurantListComponent extends Div implements HasUrlParameter<Integer> {

    private int restaurantId;
    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter Integer parameter) {
        this.restaurantId = parameter;
        log.info(String.valueOf(restaurantId));
        buildUI();
    }

    void buildUI()
    {
        add(showRestaurants());
    }

    private Component showRestaurants()
    {
        return new H1("Hello");
    }




}
