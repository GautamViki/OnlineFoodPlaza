package com.masai.service;

import com.masai.entity.Address;
import com.masai.entity.Customer;
import com.masai.exception.FoodPlazaException;
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
    @Autowired
    private CustomerDao customerDao;


    @Override
    public List<Address> viewAddress(Integer id) {
        Optional<Customer>opt=customerDao.findById(id);
            Customer customer=opt.get();
            List<Address> addresses=customer.getAddress();
            return addresses;
        }

    @Override
    public String addAddress(Integer id,Address address) {
        Optional<Customer> opt = customerDao.findById(id);

            Customer customer = opt.get();
            List<Address> addresses = customer.getAddress();
            addresses.add(address);
            customerDao.save(customer);
            return "address added";

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

//    @Override
//    public String removeAddress(Integer id, Integer idx) {
//        Optional<Customer>opt=customerDao.findById(id);
//        Customer customer=opt.get();
//        List<Address>addresses=customer.getAddress();
//        addresses.remove(idx);
//        System.out.println(addresses+"***********************");
//        customer.setAddress(addresses);
//        customerDao.save(customer);
//        return "Address deleted";
//    }
}
