package com.example.demo.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodItems {

    @Id
    @Getter @Setter
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long foodId;

    @Getter @Setter
    private String uid;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private int price;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private int qty;

    @Getter @Setter
    private String tableId;

    public FoodItems(){}

    public FoodItems(String uid, String name, String description, Integer price, Integer qty){
        this.uid = uid;
        this.name = name;
        this.description = description;
        this.price = price;
        this.qty = qty;
    }

}
