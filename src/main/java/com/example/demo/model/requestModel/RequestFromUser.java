package com.example.demo.model.requestModel;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

public class RequestFromUser {

    @Getter @Setter
    private final String password;

    @Getter @Setter
    @Email
    private final String username;

    public RequestFromUser(String username, String password){
        this.password = password;
        this.username = username;
    }

}
