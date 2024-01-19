package com.example.application.views;


import com.example.application.views.forms.LoginComponent;
import com.example.application.views.forms.SignupComponent;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;

/**
 * The main view is a top-level placeholder for other views.
 */

public class MainLayout extends AppLayout {


    public MainLayout() {
//        setPrimarySection(Section.DRAWER);
//        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        H1 appName = new H1("Mumbai's Best Food");
        appName.addClassNames("text-l", "m-m");
        appName.getStyle().setColor("RED");

        RouterLink loginLink = new RouterLink("Log In", LoginComponent.class);
        loginLink.addClassNames("text-s", "m-m");

        RouterLink signupLink = new RouterLink("Sign Up", SignupComponent.class);
        signupLink.addClassNames("text-s", "m-m");

        HorizontalLayout header = new HorizontalLayout(appName,loginLink,signupLink);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidthFull();
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);
    }



  /*  private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }


    private void addDrawerContent() {
        H1 appName = new H1("My App");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("Hello World", HelloWorldView.class, LineAwesomeIcon.GLOBE_SOLID.create()));
        nav.addItem(new SideNavItem("About", AboutView.class, LineAwesomeIcon.FILE.create()));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }*/
}
