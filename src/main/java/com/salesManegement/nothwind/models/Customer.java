package com.salesManegement.nothwind.models;

public class Customer {
    private String CustomerID;
    private String CompanyName;
    private String ContactName;
    private String ContactTitle;
    private String Address;
    private String City;
    private String PostalCode;
    private String CEP;
    private String Country;
    private String Phone;
    
    public String getContactTitle() {
        return ContactTitle;
    }
    public void setContactTitle(String contactTitle) {
        ContactTitle = contactTitle;
    }
    public String getCustomerID() {
        return CustomerID;
    }
    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }
    public String getCompanyName() {
        return CompanyName;
    }
    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }
    public String getContactName() {
        return ContactName;
    }
    public void setContactName(String contactName) {
        ContactName = contactName;
    }
    public String getCity() {
        return City;
    }
    public void setCity(String city) {
        City = city;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return "Customer [CustomerID=" + CustomerID + ", CompanyName=" + CompanyName + ", ContactName=" + ContactName
                + ", City=" + City + ", Phone=" + Phone + "]";
    }
}
