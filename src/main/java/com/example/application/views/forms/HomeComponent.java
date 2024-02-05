package com.example.application.views.forms;

import com.example.application.dto.DateAndTime;
import com.example.application.dto.Response;
import com.example.application.exception.ErrorResponse;
import com.example.application.model.Customer;
import com.example.application.model.FoodType;
import com.example.application.model.TopBrands;
import com.example.application.presenter.HomeViewPresenter;
import com.example.application.presenter.LogoutViewPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.VaadinSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Route(value = "home", layout = CustomerHeaderView.class)
@CssImport("./styles/home-view.css")
@Slf4j
public class HomeComponent extends VerticalLayout implements HasUrlParameter<Integer>, BeforeEnterObserver {

    private int customerId;

    @Autowired
    private LogoutViewPresenter logoutViewPresenter;

    @Autowired
    private HomeViewPresenter homeViewPresenter;

    @Autowired
    private DateAndTime dateAndTime;

    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter Integer parameter) {
        this.customerId = parameter;
        buildUI();
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (VaadinSession.getCurrent().getAttribute("loggedInUser") == null) {
            beforeEnterEvent.rerouteTo("");
        }
    }

    void buildUI() {
        removeAll();
        add(createWelcomeMessage());
        add(createFoodType());
        add(createBrands());
    }

    private Component createWelcomeMessage() {
        Customer customer = null;
        if (customerId != 0) {
            try {
                customer = logoutViewPresenter.getCustomerById(customerId).getResponseData();
            } catch (ErrorResponse authenticationException) {
                Notification.show("Authentication error: " + authenticationException.getResponse().getErrMessage());
            }
        }
        assert customer != null;
        H2 welcomeMessage = new H2(dateAndTime.getGreetingMessage() + " " + customer.getCustomerName() + ", Welcome to Mumbai's Best Food.");
        welcomeMessage.getStyle().setColor("#008000").setMarginLeft("80px").setFont("Cursive");
        return welcomeMessage;
    }

    private Component createFoodType() {
        VerticalLayout mainLayout = new VerticalLayout();
        H3 title = new H3("Inspiration For Your First Order!");
        title.getStyle().setColor("BLUE");
        mainLayout.add(title);
        mainLayout.getStyle().setMarginLeft("130px");
        HorizontalLayout layout = new HorizontalLayout();
        layout.getStyle().setBackgroundColor("#F8F8FF");
        Response<List<FoodType>> foodData = getRestaurantFoodTypes();
        List<FoodType> foodTypes = foodData.getResponseData();
        for (FoodType foodType : foodTypes) {
            VerticalLayout foodTypeLayout = new VerticalLayout();
            foodTypeLayout.setAlignItems(FlexComponent.Alignment.CENTER);
            Image foodTypeImage = new Image(foodType.getFoodTypeImage(), foodType.getFoodTypeName());
            foodTypeImage.getStyle().setCursor("Pointer");
            foodTypeImage.setWidth("150px");
            foodTypeImage.setHeight("150px");
            Paragraph foodTypeName = new Paragraph(foodType.getFoodTypeName());
            foodTypeName.getStyle().setCursor("Pointer").setColor("#000080");
            foodTypeLayout.add(foodTypeImage, foodTypeName);
            foodTypeLayout.addClickListener(event -> {
                String restaurantUrl = "restaurants/" + foodType.getFoodTypeName();
                UI.getCurrent().navigate(restaurantUrl);
            });
            layout.add(foodTypeLayout);
        }
        mainLayout.add(layout);
        return mainLayout;
    }


    private Component createBrands() {
        VerticalLayout mainLayout = new VerticalLayout();
        H3 title = new H3("Top Brands For You...");
        title.getStyle().setColor("RED");
        mainLayout.add(title);
        mainLayout.getStyle().setMarginLeft("130px");
        HorizontalLayout layout = new HorizontalLayout();
        layout.getStyle().setBackgroundColor("#ffece6");
        Response<List<TopBrands>> response = homeViewPresenter.viewAllTopBrands();
        List<TopBrands> topBrands = response.getResponseData();
        for (TopBrands topBrand : topBrands) {
            VerticalLayout topBrandLayout = new VerticalLayout();
            topBrandLayout.setAlignItems(FlexComponent.Alignment.CENTER);
            Image topBrandImage = new Image(topBrand.getBrandImage(), topBrand.getBrandName());
            topBrandImage.getStyle().setCursor("Pointer");
            topBrandImage.setWidth("150px");
            topBrandImage.setHeight("150px");
            Paragraph topBrandName = new Paragraph(topBrand.getBrandName());
            topBrandName.getStyle().setCursor("Pointer").setColor("#ff3c00");
            topBrandLayout.add(topBrandImage, topBrandName);
            topBrandLayout.addClickListener(
                    e -> UI.getCurrent().navigate("restaurants")
            );
            layout.add(topBrandLayout);
        }
        mainLayout.add(layout);
        return mainLayout;
    }


    private Response<List<FoodType>> getRestaurantFoodTypes() {
        Response<List<FoodType>> foodData = new Response<>();
        try {
            foodData = homeViewPresenter.viewAllFoodTypes();
        } catch (ErrorResponse errorResponse) {
            Notification.show("Error:" + errorResponse.getResponse().getErrMessage());
        }
        return foodData;
    }

}



