package com.example.application.views.forms;

import com.example.application.dto.Response;
import com.example.application.exception.ErrorResponse;
import com.example.application.model.Customer;
import com.example.application.model.CustomerAddress;
import com.example.application.model.SignUp;
import com.example.application.presenter.RegisterViewPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.BeforeLeaveEvent;
import com.vaadin.flow.router.BeforeLeaveObserver;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "signup")
@Slf4j
@CssImport("./styles/signup-view.css")
public class SignupComponent extends VerticalLayout implements BeforeLeaveObserver {

    @PostConstruct
    void buildRegisterUI() {
        addClassName("signup_form_layout");
        add(createRegisterComponent());
        setSizeFull();
    }

    H1 title = new H1("Sign In");
    TextField customerName = new TextField("Name");
    TextField customerContactNo = new TextField("Contact Number");
    TextField customerEmailId = new TextField("Email Id");
    TextField customerCity = new TextField("City");
    TextField customerStreet = new TextField("Street");
    TextField customerPinCode = new TextField("PIN code");
    TextField username = new TextField("Username");
    PasswordField password = new PasswordField("Password");
    Button registerButton = new Button("Register");
    Binder<Customer> binder = new BeanValidationBinder<>(Customer.class);
    Customer customer = new Customer();
    @Autowired
    private RegisterViewPresenter registerViewPresenter;

    private Component createRegisterComponent() {

        binder.forField(customerName).bind("customerName");
        binder.forField(customerContactNo).bind("customerContactNo");
        binder.forField(customerEmailId).bind("customerEmailId");

        customer.setCustomerAddress(new CustomerAddress());
        binder.forField(customerCity).bind("customerAddress.customerCity");
        binder.forField(customerStreet).bind("customerAddress.customerStreet");
        binder.forField(customerPinCode).bind("customerAddress.customerPinCode");

        customer.setSignUp(new SignUp());
        binder.forField(username).bind("signUp.username");
        binder.forField(password).bind("signUp.password");

        FlexLayout registerContainer = new FlexLayout();
        registerContainer.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        registerContainer.setJustifyContentMode(JustifyContentMode.CENTER);
        registerContainer.setAlignItems(Alignment.CENTER);

        registerContainer.setWidth("35%");
        registerContainer.setHeight("90%");
        registerContainer.getStyle().setMarginTop("50px").setMarginLeft("500px").setBackground("White");


        title.getStyle().setColor("Blue");

        customerName.setWidth("70%");
        customerName.setRequired(true);

        customerContactNo.setRequired(true);
        customerContactNo.setWidth("70%");

        customerEmailId.setRequired(true);
        customerEmailId.setWidth("70%");

        customerCity.setRequired(true);
        customerCity.setWidth("70%");

        customerStreet.setWidth("70%");

        customerPinCode.setRequired(true);
        customerPinCode.setWidth("70%");

        username.setRequired(true);
        username.setWidth("70%");

        password.setRequired(true);
        password.setWidth("70%");

        registerButton.getStyle().setMarginTop("3%").setMarginBottom("3%").setColor("White").setCursor("Pointer");
        registerButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);


        registerButton.setEnabled(false);
        binder.addStatusChangeListener(e -> registerButton.setEnabled(binder.isValid()));

        registerButton.addClickListener(event -> saveCustomer());

        registerContainer.add(title, customerName, customerContactNo, customerEmailId, customerCity, customerStreet, customerPinCode, username, password, registerButton);
        return registerContainer;
    }

    private void saveCustomer() {
        try {
            binder.writeBean(customer);
            Response<Customer> response = registerViewPresenter.addCustomer(customer);
            Notification.show("Registration Successful");
            String homeUrl = "home/" + response.getResponseData().getCustomerId();
            UI.getCurrent().navigate(homeUrl);
        } catch (ValidationException validationException) {
            Notification.show("Validation error: " + validationException.getMessage());
        } catch (ErrorResponse errorResponse) {
            Notification.show("Authentication error: " + errorResponse.getResponse().getErrMessage());
        }

    }

    @Override
    public void beforeLeave(BeforeLeaveEvent event) {
        if (binder.hasChanges()) {
            BeforeLeaveEvent.ContinueNavigationAction action =
                    event.postpone();
            ConfirmDialog confirmDialog = new ConfirmDialog();
            confirmDialog.setText("You have unsaved changes! Are you sure you want to leave?");
            confirmDialog.setCancelable(true);
            confirmDialog.addConfirmListener(__ -> action.proceed());
            confirmDialog.addCancelListener(__ -> action.cancel());
            confirmDialog.open();
        }
    }


}


