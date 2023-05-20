package com.salesManegement.nothwind.controllers;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return "redirect:/"+ order.OrderID;
    }

    @PostMapping("/registerProduct")
    public String registerProduct(@ModelAttribute Product product) {
        this.productRepository.save(product);
        System.out.println(product);
        return "redirect:/product";
    }

    @PostMapping("customer/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer customer) {
        if (this.customerRepository.findById(customer.getCustomerID()).isPresent()) {
            this.customerRepository.deleteById(customer.getCustomerID());
        }
        this.customerRepository.save(customer);
        System.out.println(customer);
        return "redirect:/customer";
    }

    @GetMapping("/customer")
    public ModelAndView showCustomersList() {
        ModelAndView mv = new ModelAndView("customer");
        Iterable<Customer> customersList = customerRepository.findAll();
        mv.addObject("customers", customersList);
        return mv;
    }

    @GetMapping("/selectThe5ProductsWithLessQuantity")
    public ModelAndView show5ProductsWithLessQuantity() {
        ModelAndView mv = new ModelAndView("selectThe5ProductsWithLessQuantity");
        Iterable<Product> customersList = productRepository.execSelectThe5ProductsWithLessQuantityProcedure();
        mv.addObject("products", customersList);
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

    @GetMapping("/addOrder")
    public ModelAndView showAddOrder() {
        ModelAndView mv = new ModelAndView("addOrder");
        Iterable<Product> productsList = productRepository.findAll();
        mv.addObject("products", productsList);
        return mv;
    }

    @GetMapping("order/{id}")
    public ModelAndView orderDetails(@PathVariable("id") String id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
		ModelAndView mv = new ModelAndView("orderDetails");
        Iterable<Product> productsList = productRepository.findAll();
        
        if (optionalOrder.isPresent()) {
            mv.addObject("orders", optionalOrder.get());
            mv.addObject("products", productsList);
            //Iterable<Product> addedProductsList = productRepository.findByOrder(optionalOrder.get());
            //mv.addObject("addedProducts", addedProductsList);
            return mv;
        } else {
            throw new NoSuchElementException("Customer not found with ID: " + id);
        }
    }
    @GetMapping("/customer/{CustomerID}")
    public ModelAndView customerDetails(@PathVariable("CustomerID") String id) {
        Optional<Customer> optionalOrder = customerRepository.findById(id);
		ModelAndView mv = new ModelAndView("updateCustomer");
        
        if (optionalOrder.isPresent()) {
            mv.addObject("customers", optionalOrder.get());
            return mv;
        } else {
            throw new NoSuchElementException("Customer not found with ID: " + id);
        }
    }

    @RequestMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id") String id) {
        Optional<Customer> optionalOrder = customerRepository.findById(id);

        if (optionalOrder.isPresent()) {
            customerRepository.delete(optionalOrder.get());
        } else {
            throw new NoSuchElementException("Customer not found with ID: " + id);
        }
        return "redirect:/customer";
    }

    @PostMapping("/{id}")
    public String registerProductsInOrder(@PathVariable("id") String orderId, @RequestParam("options") Long opcao) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        Optional<Product> optionalProduct = productRepository.findById(String.valueOf(opcao));
    
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
    
            if(optionalOrder.isPresent()){
                Product product = optionalProduct.get();
                //product.setOrder(order);
                productRepository.save(product);
            }
        } else {
            throw new NoSuchElementException("Customer not found with ID: " + orderId);
        }
    
        return "redirect:/{id}";
    }
}