package com.masai.service;

import com.masai.entity.Address;
import com.masai.entity.Customer;
import com.masai.repository.AddressDao;
import com.masai.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService{
@Autowired
    private AddressDao addressDao;
private CustomerDao customerDao;

    @Override
    public List<Address> viewAddress(Integer id) {
        Optional<Customer> opt = customerDao.findById(id);
        Customer customer = opt.get();
        List<Address> addresses = customer.getAddress();
        return addresses;
    }

    @Override
    public List<Address> updateAddress(Integer id, Integer idx, String city, String state) {
        Optional<Customer> opt = customerDao.findById(id);
        Customer customer = opt.get();
        List<Address> addresses = customer.getAddress();
        Address address = addresses.get(idx);
        address.setCity(city);
        address.setState(state);
        customerDao.save(customer);
        return addresses;
    }
}
