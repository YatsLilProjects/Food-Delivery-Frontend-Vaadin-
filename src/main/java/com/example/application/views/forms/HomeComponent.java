package com.example.application.views.forms;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;


@Route(value = "home", layout = MainLayout.class)
@CssImport("./styles/login-view.css")
@Slf4j
public class HomeComponent extends VerticalLayout implements HasUrlParameter<Integer> {

    @Override
    public void setParameter(BeforeEvent beforeEvent, Integer parameter) {
        System.out.println("Parameter in home view" + parameter);
    }

    @PostConstruct
    void buildUI() {
//       add(createFoodTypes());


    }

 /*   private Component createFoodTypes() {
        HorizontalLayout layout=new HorizontalLayout();

        return null;
    }*/


}
