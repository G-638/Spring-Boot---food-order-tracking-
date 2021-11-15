package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "user")
public class User {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(nullable = false)
    @Getter @Setter
    private String name;

    @Email
    @Column(nullable = false)
    @Getter @Setter
    private String email;

    @JsonIgnore
    @Column(nullable = false)
    @Getter @Setter
    private String password;

    @Column(nullable = false)
    @Getter @Setter
    private String uid;

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

    public User(){}

    public User(String name, String email, String password, String uid, String role, String branch, String gender, String address, String phoneNo){
        this.name = name;
        this.email = email;
        this.password = password;
        this.uid = uid;
        this.role = role;
        this.branch = branch;
        this.gender = gender;
        this.address = address;
        this.phoneNo = phoneNo;
    }

}