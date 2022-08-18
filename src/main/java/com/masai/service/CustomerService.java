package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.masai.entity.Customer;
import com.masai.entity.UserType;

@Service
public interface CustomerService {

    public Customer addCustomer(Customer customer, UserType usertype)throws Exception;

    public Customer viewCustomer(Integer id);
    //
    public Customer updateCustomer(Integer id, String mobile, String email);
    
    public Customer findByNameAndPassword(String userName, String password);

    public Customer removeCustomer(Integer id);
    //
    public List<Customer> viewAllCustomers();
}
