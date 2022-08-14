package com.masai.controller;

import com.masai.entity.Customer;
import com.masai.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerControl {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public Customer viewCustomerHandler(@PathVariable Integer id) {
        return customerService.viewCustomer(id);
    }

    @PostMapping("/")
    public Customer saveCustomerHandler(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/{id}/{mobile}/{email}")
    public Customer updateCustomerHandler(@PathVariable Integer id,
                                          @PathVariable String mobile, @PathVariable String email) {
        Customer customer = customerService.updateCustomer(id, mobile, email);
        return customer;
    }

    @DeleteMapping("/{id}")
    public String removeCustomerHandler(@PathVariable Integer id) {
        Customer customer = customerService.removeCustomer(id);
        return "Deleted " + customer;
    }

    @GetMapping("/all")
    public List<Customer> viewAllCustomersHandler() {
        return customerService.viewAllCustomers();
    }
}
