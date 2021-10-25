package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

public class FoodList {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private int price;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private int qty;

    @Getter @Setter
    private String productId;

    @Getter @Setter
    private String tableId;

    public FoodList(String name, String description, Integer price, Integer qty, String productId){
        this.name = name;
        this.description = description;
        this.price = price;
        this.qty = qty;
        this.productId = productId;
    }

}
