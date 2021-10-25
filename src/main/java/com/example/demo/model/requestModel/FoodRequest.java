package com.example.demo.model.requestModel;

import lombok.Getter;
import lombok.Setter;

public class FoodRequest {

    @Getter @Setter
    private String productId;

    @Getter @Setter
    private int qty;

}
