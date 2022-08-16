package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.masai.entity.Customer;

@Service
public interface CustomerService {

    public Customer addCustomer(Customer customer);

    public Customer viewCustomer(Integer id);
    //
    public Customer updateCustomer(Integer id, String mobile, String email);

    public Customer removeCustomer(Integer id);
    //
    public List<Customer> viewAllCustomers();
}
