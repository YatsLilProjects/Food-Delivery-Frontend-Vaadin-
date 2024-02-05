package com.example.application.views.forms;

import com.example.application.dto.Response;
import com.example.application.exception.ErrorResponse;
import com.example.application.model.CuisineTypeData;
import com.example.application.model.Restaurant;
import com.example.application.presenter.RestaurantListViewPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "restaurants", layout = CustomerHeaderView.class)
@Slf4j
public class RestaurantListComponent extends Div implements HasUrlParameter<String> {

    @Autowired
    private RestaurantListViewPresenter restaurantListViewPresenter;

    String foodTypeName;

    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String parameter) {
        this.foodTypeName = parameter;
        buildUI();
    }

    void buildUI() {
        add(showRestaurants());
    }

    private Component showRestaurants() {
    /*    HorizontalLayout mainLayout = new HorizontalLayout();
        Response<List<Restaurant>> restaurants = getRestaurantsBasedOnFoodType();
        List<Restaurant> restaurantList = restaurants.getResponseData();
        for (Restaurant restaurant : restaurantList) {

            VerticalLayout restaurantCard = new VerticalLayout();
            restaurantCard.getStyle().setWidth("300px").setMarginLeft("10px");
            restaurantCard.setAlignItems(FlexComponent.Alignment.START);

            Image restaurantImage = new Image(restaurant.getRestaurantImage(), "Restaurant Image");
            restaurantImage.getStyle().setWidth("300px").setHeight("300px").set("border", "2px solid grey");
            restaurantCard.add(restaurantImage);

            H4 restaurantNameLabel = new H4(restaurant.getRestaurantName());
            restaurantNameLabel.getStyle().setFontSize("1.5em");
            restaurantCard.add(restaurantNameLabel);

        *//*    H4 cuisineLocationLabel = new H4(restaurant.getCuisine() + " | " + restaurant.getLocation());
            restaurantCard.add(cuisineLocationLabel);*//*
            mainLayout.add(restaurantCard);
        }
        return mainLayout;*/


        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.getStyle().setMarginLeft("25%").setMarginTop("100px");
        Response<List<Restaurant>> restaurants = getRestaurantsBasedOnFoodType();
        List<Restaurant> restaurantList = restaurants.getResponseData();
        for (Restaurant restaurant : restaurantList) {

            Div restaurantDiv = new Div();
            restaurantDiv.getStyle().setWidth("300px").setMarginLeft("10px").set("border", "1px solid #e0e0e0").setBorderRadius("15px").setCursor("Pointer");

            Div imageDiv = new Div();
            imageDiv.getStyle().setWidth("300px").setHeight("250px");
            Image restaurantImage = new Image(restaurant.getRestaurantImage(), "Restaurant Image");
            restaurantImage.getStyle().setWidth("100%").setHeight("100%");
            imageDiv.add(restaurantImage);

            Div infoDiv = new Div();
            infoDiv.getStyle().setWidth("300px").setHeight("85px");
            Paragraph restaurantNameParagraph = new Paragraph(restaurant.getRestaurantName());
            restaurantNameParagraph.getStyle().setFontSize("1.5em").setColor("Black").setFont("Bolder").setMarginBottom("0px");
            List<CuisineTypeData> cuisineTypes = restaurant.getCuisineTypeData();
            List<String> cuisines = cuisineTypes.stream().map(CuisineTypeData::getCuisineType).toList();
            Paragraph restaurantCuisineParagraph = new Paragraph(String.join(", ", cuisines));
            restaurantCuisineParagraph.getStyle().setFontSize("1em").setColor("Gray").setFont("Normal").setMarginTop("0px");
            infoDiv.add(restaurantNameParagraph, restaurantCuisineParagraph);

            Div locationDiv = new Div();
            Paragraph restaurantLocationParagraph = new Paragraph(restaurant.getRestaurantLocation());
            restaurantLocationParagraph.getStyle().setFontSize("1em").setColor("#A8A8A8").setFont("Normal");
            locationDiv.add(restaurantLocationParagraph);

            restaurantDiv.add(imageDiv, infoDiv, locationDiv);

            mainLayout.add(restaurantDiv);
        }
        return mainLayout;
    }


    private Response<List<Restaurant>> getRestaurantsBasedOnFoodType() {
        Response<List<Restaurant>> restaurants = new Response<>();
        try {
            restaurants = restaurantListViewPresenter.findRestaurantsByMenuItemName(foodTypeName);
        } catch (ErrorResponse errorResponse) {
            Notification.show("Error:" + errorResponse.getResponse().getErrMessage());
        }
        return restaurants;
    }


}
