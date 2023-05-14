package com.salesManegement.nothwind.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/")
    public String index() {
        return "redirect:/customer";
    }

    @PostMapping("/registerCustomer")
    public String registerCustomer(@ModelAttribute Customer customer) {
        this.customerRepository.save(customer);
        System.out.println(customer);
        return "redirect:/customer";
    }

    @PostMapping("/registerOrder")
    public String registerOrder(@ModelAttribute Order order) {
        this.orderRepository.save(order);
        System.out.println(order);
        return "redirect:/order";
    }

    @PostMapping("/registerProduct")
    public String registerProduct(@ModelAttribute Product product) {
        this.productRepository.save(product);
        System.out.println(product);
        return "redirect:/product";
    }

    @GetMapping("/customer")
    public ModelAndView showCustomersList() {
        ModelAndView mv = new ModelAndView("customer");
        Iterable<Customer> customersList = customerRepository.findAll();
        mv.addObject("customers", customersList);
        return mv;
    }

    @GetMapping("/order")
    public ModelAndView showOrdersList() {
        ModelAndView mv = new ModelAndView("order");
        Iterable<Order> ordersList = orderRepository.findAll();
        mv.addObject("orders", ordersList);
        return mv;
    }

    @GetMapping("/product")
    public ModelAndView showProductsList() {
        ModelAndView mv = new ModelAndView("product");
        Iterable<Product> productsList = productRepository.findAll();
        mv.addObject("products", productsList);
        return mv;
    }
    
    //TO-DO
    @GetMapping(value="/{id}")
	public ModelAndView detalhesEvento(@PathVariable("id") long id){
		//Customer customer = customerRepository.findByID(id);
		ModelAndView mv = new ModelAndView("customerDetails");
		//mv.addObject("customer", customer);
		
		return mv;
	}
}