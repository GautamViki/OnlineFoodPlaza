package com.masai.controller;

import com.masai.entity.Customer;
import com.masai.entity.UserType;
import com.masai.exception.InvalidId;
import com.masai.exception.NullValueException;
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

    @PostMapping("/")
    public Customer saveCustomerHandler(@RequestBody Customer customer) throws Exception {
        return customerService.addCustomer(customer,UserType.Customer);
    }
    @GetMapping("/{id}")
    public Customer viewCustomerHandler(@PathVariable Integer id) {
        if(id==null){
            throw new NullValueException("Invalid URI");
        }
        else {
            return customerService.viewCustomer(id);
        }
    }

    @PutMapping("/{id}/{mobile}/{email}")
    public Customer updateCustomerHandler(@PathVariable Integer id,
                                          @PathVariable String mobile, @PathVariable String email) {
        if(id==null){
            throw new InvalidId("Invalid URI");
        }else {
            Customer customer = customerService.updateCustomer(id, mobile, email);
            if(customer==null){
                throw new NullValueException("Customer not found");
            }
            return customer;
        }

    }

    @DeleteMapping("/{id}")
    public String removeCustomerHandler(@PathVariable Integer id) {
        if(id==null){
            throw new InvalidId("Invalid URI");
        }else {
            Customer customer = customerService.removeCustomer(id);
            if(customer==null){
                throw new NullValueException("Customer not found");
            }
            return "Deleted " + customer;
        }
    }

    @GetMapping("/all")
    public List<Customer> viewAllCustomersHandler() {
        List<Customer>customers=customerService.viewAllCustomers();
        if(customers.size()==0){
            throw new NullValueException("Customer not found");
        }
        return customers;
    }
}
