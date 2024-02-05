package com.example.application.views.forms;



import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Route(value = "logout")
@Slf4j
public class LogoutComponent extends VerticalLayout {

    @PostConstruct
    void buildUI() {
        add(createLogoutComponent());
    }

    private Component createLogoutComponent() {
        VaadinSession.getCurrent().getSession().invalidate();
        return new H1("You are Logged Out");
    }


}
