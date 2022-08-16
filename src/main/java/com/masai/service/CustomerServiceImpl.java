package com.masai.service;

import java.util.List;
import java.util.Optional;

import com.masai.entity.Address;
import com.masai.repository.AddressDao;
import com.masai.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.entity.Customer;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AddressDao addressDao;

    @Override
    public Customer addCustomer(Customer customer) {
        List<Address>addresses=customer.getAddress();
        return customerDao.save(customer);
    }

    @Override
    public Customer viewCustomer(Integer id) {
        Optional<Customer> opt = customerDao.findById(id);
        Customer customer = opt.get();
        return customer;
    }
    //
//    @Override
    public Customer updateCustomer(Integer id, String mobile, String email) {
        Optional<Customer> opt = customerDao.findById(id);
        Customer customer1 = opt.get();
        customer1.setEmail(email);
        customer1.setMobileNumber(mobile);
        return customerDao.save(customer1);
    }

    @Override
    public Customer removeCustomer(@PathVariable Integer id) {
        Optional<Customer> opt = customerDao.findById(id);
        Customer customer = opt.get();
        customerDao.delete(customer);
        return customer;
    }

    @Override
    public List<Customer> viewAllCustomers() {
        List<Customer> customers = customerDao.findAll();
        return customers;
    }

}
