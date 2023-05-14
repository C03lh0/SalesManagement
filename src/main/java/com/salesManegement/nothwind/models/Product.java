
package com.salesManegement.nothwind.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "Products")
public class Product {

    @Id
    @Column(name = "ProductID")
    private String ProductID;

    @Column(name = "ProductName")
    private String ProductName;

    @Column(name = "SupplierID")
    private int SupplierID;

    @Column(name = "CategoryID")
    private int CategoryID;

    @Column(name = "QuantityPerUnit")
    private String QuantityPerUnit;

    @Column(name = "UnitPrice")
    private int UnitPrice;

    @Column(name = "UnitsInStock")
    private int UnitsInStock;

    @ManyToOne
    private Order order;

    public Order getOrder(){
        return this.order;
    }

    public void setOrder(Order order){
        this.order = order;
    }
}

