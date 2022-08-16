package com.masai.service;

import java.util.List;
import java.util.Optional;

import com.masai.entity.Address;
import com.masai.exception.FoodPlazaException;
import com.masai.repository.AddressDao;
import com.masai.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.entity.Customer;
import com.masai.entity.Foodcart;
import com.masai.entity.UserType;

import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AddressDao addressDao;

    @Override
    public Customer addCustomer(Customer customer, UserType usertype) throws Exception {
        List<Customer> listCustomer = customerDao.findAll();
        if(listCustomer.size()>0) {
            for(Customer c: listCustomer) {

                if(c.getUserName().equals(customer.getUserName())) {
                    System.out.println("User not available");
                    throw new Exception();
                }
            }
            customer.setFoodCart(new Foodcart());
            customer.setUsertype(usertype);
            return customerDao.save(customer);
        }
        else {
            customer.setFoodCart(new Foodcart());
            customer.setUsertype(usertype);
            return customerDao.save(customer);
        }
    }

    @Override
    public Customer viewCustomer(Integer id) {
        Optional<Customer> opt = customerDao.findById(id);
        if(opt.isPresent()){
            Customer customer = opt.get();
            return customer;
        }
        else {
            throw new FoodPlazaException("Customer not found");
        }
    }
    //
//    @Override
    public Customer updateCustomer(Integer id, String mobile, String email) {
        Optional<Customer> opt = customerDao.findById(id);
        if(opt.isPresent()){
            Customer customer1 = opt.get();
            customer1.setEmail(email);
            customer1.setMobileNumber(mobile);
            return customerDao.save(customer1);
        }
        else {
            throw new FoodPlazaException("Customer not found");
        }
    }

    @Override
    public Customer removeCustomer(@PathVariable Integer id) {
        Optional<Customer> opt = customerDao.findById(id);
        if(opt.isPresent()){
            Customer customer = opt.get();
            customerDao.delete(customer);
            return customer;
        }
        else {
            throw new FoodPlazaException("Customer not found");
        }
    }

    @Override
    public List<Customer> viewAllCustomers() {
        List<Customer> customers = customerDao.findAll();
        return customers;
    }

	@Override
	public Customer findByNameAndPassword(String userName, String password) {
		List<Customer> cust_list = customerDao.findAll();
		for(Customer cust: cust_list) {
			if(cust.getUserName().equals(userName) && cust.getUserPwd().equals(password)) {
				return cust;
			}
		}
		return null;
	}
}
