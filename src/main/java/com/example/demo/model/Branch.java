package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long bid;

    @Column(nullable = false)
    @Getter @Setter
    private String branch;

    @Column(nullable = false)
    @Getter @Setter
    private String branchName;

    @Column(nullable = false)
    @Getter @Setter
    private String address;

    @Column(nullable = false)
    @Getter @Setter
    private String phoneNo;
    
    public Branch(){}

    public Branch(String branch, String branchName, String address, String phoneNo){
        this.branch = branch;
        this.branchName = branchName;
        this.address =address;
        this.phoneNo = phoneNo;
    }
}
