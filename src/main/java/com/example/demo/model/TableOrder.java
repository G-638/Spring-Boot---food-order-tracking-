package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class TableOrder {

    @Id
    @Getter @Setter
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fid;

    @Getter @Setter
    @Column(nullable = false)
    private String uid;

    @Getter @Setter
    @Column(nullable = false)
    private int qty;

    @Getter @Setter
    @Column(nullable = false)
    private String tableId;

    @Column(nullable = false)
    @Getter @Setter
    private String branch;

    public TableOrder(){}

    public TableOrder(String uid, int qty , String tableId, String branch){
        this.uid = uid;
        this.qty=qty;
        this.tableId=tableId;
        this.branch=branch;
    }

}
