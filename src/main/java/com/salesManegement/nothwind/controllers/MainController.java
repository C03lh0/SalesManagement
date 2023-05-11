package com.salesManegement.nothwind.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesManegement.nothwind.models.Customer;
import com.salesManegement.nothwind.models.Order;
import com.salesManegement.nothwind.models.Product;
import com.salesManegement.nothwind.repository.CustomerRepository;
import com.salesManegement.nothwind.repository.OrderRepository;
import com.salesManegement.nothwind.repository.ProductRepository;

@Controller
public class MainController {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/addCustomer")
    public String showAddCustomer() {
        return "addCustomer";
    }

    @GetMapping("/addOrder")
    public String showAddOrder() {
        return "addOrder";
    }
    @GetMapping("/addProduct")
    public String showAddProduct() {
        return "addProduct";
    }

    @GetMapping("/order")
    public String showOrder() {
        return "order";
    }
    @GetMapping("/product")
    public String showProduct() {
        return "product";
    }

    @GetMapping("/customer")
    public String showCustomer() {
        return "customer";
    }

    @GetMapping("/")
    public String index() {
        return "customer";
    }
    @PostMapping("/registerCustomer")
    public String registerCustomer(@ModelAttribute Customer customer) {
        this.customerRepository.save(customer);
        System.out.println(customer);
        return "customer";
    }

    @PostMapping("/registerOrder")
    public String registerOrder(@ModelAttribute Order order) {
        this.orderRepository.save(order);
        System.out.println(order);
        return "order";
    }

    @PostMapping("/registerProduct")
    public String registerProduct(@ModelAttribute Product product) {
        this.productRepository.save(product);
        System.out.println(product);
        return "product";
    }
    
}