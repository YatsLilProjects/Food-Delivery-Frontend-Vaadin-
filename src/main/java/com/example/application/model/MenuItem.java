package com.example.application.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {


    private Integer menuItemId;

    @Pattern(regexp = "^[a-zA-Z0-9\\s-]+$", message = "Menu item name should consist of alphanumeric characters spaces or hyphens (a-z, A-Z, 0-9,-)")
    @NotBlank(message = "Menu item name required")

    private String menuItemName;

    @Positive(message = "Menu item price must be a positive number")
    @NotNull(message = "Menu item price required")
    private double menuItemPrice;

    private String menuItemDesc;

    private String menuItemImage;

    @NotNull(message = "Menu item type required")
    private boolean vegetarian;

    private Restaurant restaurant;

}
