package com.salesManegement.nothwind.models;
import java.sql.Date;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "Orders")
public class Order {

    @Id
    @Column(name = "OrderID")
    private String OrderID;

    @Column(name = "CustomerID")
    private String CustomerID;

    @Column(name = "OrderDate")
    private Date OrderDate;

    @Column(name = "Freight")
    private double Freight;
    
}

