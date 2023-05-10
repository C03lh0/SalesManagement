package com.salesManegement.nothwind.models;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "Order")
public class Order {

    @Id
    @Column(name = "OrderID")
    private int OrderID;

    @Column(name = "CustomerID")
    private String CustomerID;

    @Column(name = "OrderDate")
    private Date OrderDate;

    @Column(name = "Freight")
    private double Freight;
    
}

