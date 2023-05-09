package com.salesManegement.nothwind.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesManegement.nothwind.models.Customer;

public class AddCustomerController {

    @GetMapping("/")
    public String index() {
        return "addCustomer";
    }

    @PostMapping("/register")
    public String userRegistration(@ModelAttribute Customer customer) {
        System.out.println(customer);
        return "index";
    }
    
}