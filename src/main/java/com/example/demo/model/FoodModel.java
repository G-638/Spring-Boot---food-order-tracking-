package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;


public class FoodModel {
    @Getter @Setter
    String data;

    public FoodModel(String data){
        this.data = data;
    }
}
