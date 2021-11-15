package com.example.demo.model.requestModel;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;

public class RequestFromUser {

    @Column(nullable = false)
    @Getter @Setter
    private String name;

    @Getter @Setter
    private final String password;

    @Getter @Setter
    @Email
    private final String username;

    @Column(nullable = false)
    @Getter @Setter
    private String role;

    @Column(nullable = false)
    @Getter @Setter
    private String branch;

    @Column(nullable = false)
    @Getter @Setter
    private String gender;

    @Column(nullable = false)
    @Getter @Setter
    private String address;

    @Column(nullable = false)
    @Pattern(regexp="(^$|[0-9]{10})")
    @Getter @Setter
    private String phoneNo;

    public RequestFromUser(String name,String username, String password, String role, String branch, String gender, String address, String phoneNo){
        this.name = name;
        this.password = password;
        this.username = username;
        this.role = role;
        this.branch = branch;
        this.gender = gender;
        this.address = address;
        this.phoneNo = phoneNo;
    }

}
