package com.example.demo.model.responseModel;

import com.example.demo.model.FoodList;
import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseToUser {

    @Getter @Setter
    private String message;
    @Getter @Setter
    private String debugMessage;
    @Getter @Setter
    private Integer responseCode;
    @Getter @Setter
    private HttpStatus status;
    @Getter @Setter
    private Date dateTime;
    @Getter @Setter
    private ArrayList<?> data = null;
    @Getter @Setter
    private LinkedHashMap<?,?> dict = null;
    @Getter @Setter
    private FoodList itemData;
    @Getter @Setter
    private User userData;

    public ResponseToUser(String message, String debugMessage, int responseCode, HttpStatus status, Date dateTime){
        this.message = message;
        this.debugMessage = debugMessage;
        this.dateTime = dateTime;
        this.status = status;
        this.responseCode = responseCode;
    }

    public ResponseToUser(String message, int responseCode, HttpStatus status, Date dateTime){
        this.message = message;
        this.dateTime = dateTime;
        this.status = status;
        this.responseCode = responseCode;
    }

    public ResponseToUser(){}

}
