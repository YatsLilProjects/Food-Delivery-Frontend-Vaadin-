package com.example.application.views.forms;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import lombok.extern.slf4j.Slf4j;

@Route(value = "restaurant_info", layout = CustomerHeaderView.class)
@Slf4j
public class RestaurantInfoComponent extends Div {








    private Component showRestaurantsMenu()
    {
        Div mainContainer=new Div();
        mainContainer.getStyle().setMarginLeft("23%").setMarginTop("70px").setWidth("53%");



        return mainContainer;
    }



}
