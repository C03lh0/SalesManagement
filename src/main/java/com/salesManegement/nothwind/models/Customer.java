package com.salesManegement.nothwind.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "Customer")
public class Customer {
    
    @Id
    @Column(name = "CustomerID")
    private String CustomerID;

    @Column(name = "CompanyName")
    private String CompanyName;

    @Column(name = "ContactName")
    private String ContactName;

    @Column(name = "ContactTitle")
    private String ContactTitle;

    @Column(name = "Address")
    private String Address;

    @Column(name = "City")
    private String City;

    @Column(name = "PostalCode")
    private String PostalCode;

    @Column(name = "CEP")
    private String CEP;

    @Column(name = "Country")
    private String Country;

    @Column(name = "Phone")
    private String Phone;

    @Override
    public String toString() {
        return "Customer [CustomerID=" + CustomerID + ", CompanyName=" + CompanyName + ", ContactName=" + ContactName
                + ", ContactTitle=" + ContactTitle + ", Address=" + Address + ", City=" + City + ", PostalCode="
                + PostalCode + ", CEP=" + CEP + ", Country=" + Country + ", Phone=" + Phone + "]";
    }

}
