
package com.salesManegement.nothwind.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "Product")
public class Product {

    @Id
    @Column(name = "ProductID")
    private int ProductID;

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
    
}

