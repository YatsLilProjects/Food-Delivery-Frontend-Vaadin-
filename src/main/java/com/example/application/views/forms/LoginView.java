package com.example.application.views.forms;

import com.example.application.dto.CustomerResponse;
import com.example.application.exception.AuthenticationException;
import com.example.application.model.LogIn;
import com.example.application.presenter.LoginViewPresenter;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "", layout = MainLayout.class)
@CssImport("./styles/login-view.css")
@Slf4j
public class LoginView extends VerticalLayout {

    @PostConstruct
    void buildLoginUI() {
        addClassName("login_form_layout");
        UI.getCurrent().getPage().executeJs(
                "document.body.style.background = 'url(images/login-background-image1.jpg) no-repeat center center fixed';" +
                        "document.body.style.backgroundSize = 'cover';"
        );
        setSizeFull();
        add(createLoginComponent());
    }

    TextField username = new TextField("Username:");
    PasswordField password = new PasswordField("Password:");

    Button loginButton = new Button("Log in");
    Binder<LogIn> binder = new BeanValidationBinder<>(LogIn.class);
    @Autowired
    LoginViewPresenter loginViewPresenter;
    @Autowired
    LogIn logIn;

    private Component createLoginComponent() {

        binder.bindInstanceFields(this);

        /*  binder.readBean(logIn);*/

        FlexLayout loginContainer = new FlexLayout();
        loginContainer.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        loginContainer.setJustifyContentMode(JustifyContentMode.CENTER);
        loginContainer.setAlignItems(Alignment.CENTER);

        loginContainer.setWidth("25%");
        loginContainer.setHeight("45%");
        loginContainer.getStyle().setMarginTop("200px");
        loginContainer.getStyle().setMarginLeft("450px");
        loginContainer.getStyle().setBackground("White");

        H1 title = new H1("Log In");
        title.getStyle().setColor("Blue");

        username.setWidth("70%");
        username.setRequired(true);

        password.setRequired(true);
        password.setWidth("70%");

        loginButton.setWidth("70%");
        loginButton.getStyle().setMarginTop("5%");
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        loginButton.getStyle().setColor("White");
        loginButton.getStyle().setCursor("Pointer");

        loginButton.setEnabled(false);
        binder.addStatusChangeListener(e -> loginButton.setEnabled(binder.isValid()));

        loginButton.addClickListener(event -> loginCustomer());

        Span nonLinkText = new Span("Don't have an account? ");
        Anchor registerLink = new Anchor("register", "REGISTER HERE");

        Span registerText = new Span(nonLinkText, registerLink);
        registerText.getStyle().setMarginTop("2%");

        loginContainer.add(title, username, password, loginButton, registerText);
        return loginContainer;
    }


    private void loginCustomer() {
        try {
            binder.writeBean(logIn);
            CustomerResponse response = loginViewPresenter.loginCustomer(logIn);
            Notification.show((String) response.getResponseData());
        } catch (ValidationException validationException) {
            Notification.show("Validation error: " + validationException.getMessage());
        } catch (AuthenticationException authenticationException) {
            Notification.show("Authentication error: " + authenticationException.getResponse().getErrMessage());
        }
    }


}
