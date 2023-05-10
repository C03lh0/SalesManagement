package com.salesManegement.nothwind.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesManegement.nothwind.models.Customer;

@RestController
@RequestMapping("/api/customer")
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