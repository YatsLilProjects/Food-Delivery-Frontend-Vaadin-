package com.example.application.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodType {

    private Integer foodTypeId;
    private String foodTypeName;
    private String foodTypeImage;

}
