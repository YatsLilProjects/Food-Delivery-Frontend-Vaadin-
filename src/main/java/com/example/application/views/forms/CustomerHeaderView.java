package com.example.application.views.forms;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.VaadinSession;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerHeaderView extends AppLayout implements BeforeEnterObserver {

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (VaadinSession.getCurrent().getAttribute("loggedInUser")==null) {
            beforeEnterEvent.rerouteTo("");
        }
    }

    @PostConstruct
    void routeToPage() {
        if (VaadinSession.getCurrent().getAttribute("loggedInUser")!=null) {
            addToNavbar(buildNavBar());
            DrawerToggle toggle = (DrawerToggle) buildDrawer();
            addToNavbar(toggle);}
        else {
            UI.getCurrent().navigate("");
        }
    }

    private Component buildNavBar() {

        H1 appName = new H1("Mumbai's Best Food");
        appName.addClassNames("text-l", "m-m");
        appName.getStyle().setColor("RED");

        TextField searchBar = new TextField();
        searchBar.setPlaceholder("Search for a Restaurant by Name, Location, or Cuisine Type...");
        searchBar.getStyle().setMarginLeft("100px").setWidth("550px");

        Button searchButton = new Button(new Icon(VaadinIcon.SEARCH));
        searchButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        searchButton.getStyle().setCursor("Pointer");
        searchButton.addClickListener(e -> {
            String searchQuery = searchBar.getValue();
            Notification.show("Search query: " + searchQuery);
        });

        Tabs tabs = getTabs();

        FlexLayout layout = new FlexLayout();
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        layout.getStyle().set("margin-right", "30%");
        layout.add(appName,tabs,searchBar,searchButton);

        return layout;
    }

    private Tabs getTabs() {
        Object storedValue= VaadinSession.getCurrent().getAttribute("loggedInUser");
        int customerId= Integer.parseInt((String) storedValue);
        Tabs tabs = new Tabs();
        tabs.getStyle().set("margin", "auto").setWidth("340px");
        tabs.add(

                createTab("Home", HomeComponent.class, customerId),
                createTab("View Cart",HomeComponent.class, customerId),
                createTab("View Orders",HomeComponent.class, customerId)
        );
        return tabs;
    }

    private Tab createTab(String viewName, Class className, Integer parameter) {
        RouterLink link = new RouterLink(viewName, className);
        link.setRoute(className, parameter);
        return new Tab(link);
    }

    private Component buildDrawer() {
        RouterLink logoutLink = new RouterLink("Logout", LogoutComponent.class);
        logoutLink.addClassNames("text-s", "m-m");
        addToDrawer(logoutLink);

        DrawerToggle toggle = new DrawerToggle();
        toggle.getStyle().setCursor("Pointer").setBackgroundColor("BLUE").setColor("WHITE");
        setDrawerOpened(false);


        return toggle;
    }


}
