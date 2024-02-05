package com.example.application.views;


import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.RouterLayout;
import lombok.extern.slf4j.Slf4j;

/**
 * The main view is a top-level placeholder for other views.
 */

@Slf4j
public class MainLayout extends AppLayout implements RouterLayout {

}

















 /*  public MainLayout() {
        addHeaderContent();
        addDrawerContent();
    }

    private void addHeaderContent() {
        H1 appName = new H1("Mumbai's Best Food");
        appName.addClassNames("text-l", "m-m");
        appName.getStyle().setColor("RED");

        TextField searchBar = new TextField();
        searchBar.setPlaceholder("Search for a Restaurant by Name, Location, or Cuisine Type...");
        searchBar.getStyle().setMarginRight("10px");

        Button searchButton = new Button(new Icon(VaadinIcon.SEARCH));
        searchButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        searchButton.getStyle().setCursor("Pointer");
        searchButton.addClickListener(e -> {
            String searchQuery = searchBar.getValue();
            Notification.show("Search query: " + searchQuery);
        });

        RouterLink homeLink = createHomeLink();

        HorizontalLayout header = new HorizontalLayout(appName);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setFlexGrow(1, searchBar);
        header.setAlignItems(FlexComponent.Alignment.CENTER);

        Div spacerLeft = new Div();
        spacerLeft.setWidth("500px");
        Div spacerRight = new Div();
        spacerRight.setWidth("400px");

        addToNavbar(header,homeLink,spacerLeft, searchBar, searchButton, spacerRight);

        DrawerToggle toggle = new DrawerToggle();
        toggle.getStyle().setCursor("Pointer");
        addToNavbar(toggle);
        setDrawerOpened(false);
    }

    private void addDrawerContent() {
        RouterLink logoutLink = new RouterLink("Logout", LogoutComponent.class);
        logoutLink.addClassNames("text-s", "m-m");
        addToDrawer(logoutLink);

    }

    private RouterLink createHomeLink() {
        Object storedValue = VaadinSession.getCurrent().getAttribute("loggedInUser");
        int customerId = Integer.parseInt((String) storedValue);
        RouterLink homeLink = new RouterLink("Home", HomeComponent.class);
        homeLink.setRoute(HomeComponent.class, customerId);
        return homeLink;
    }*/
