package com.masai.service;

import com.masai.entity.Address;
import com.masai.entity.Customer;
import com.masai.entity.User;
import com.masai.repository.AddressDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService{
@Autowired
    private AddressDao addressDao;
@Autowired
    private CustomerDao customerDao;

    private UserDao userDao;
    private  LoginService loginService;

//    @Override
//    public User addAddress(Address address){
//        User user=loginService.loginDetail();
//        Optional<Customer> opt = customerDao.findById(user.getCustomerId());
//        address.setUser(user);
//        addressDao.save(address);
//        opt.get().getAddress().add(address);
//        customerDao.save(opt.get());
//        return user;
//    }


//    @Override
//    public User addAddress(Integer id, Address address) {
//        Optional<User>opt=userDao.findById(id);
//        User user=opt.get();
//        return user;
//    }

    @Override
    public String addAddress(Integer id, Address address) throws Exception {
        Optional<Customer> opt = customerDao.findById(id);
//        System.out.println(opt.get().getFirstName());
        if(opt.isPresent()){
            addressDao.save(address);
            opt.get().getAddress().add(address);
            customerDao.save(opt.get());
            return "address added";
        }
        else {
            throw new Exception("not exist");
        }


    }

    @Override
    public List<Address> viewAddress(Integer id) {
        Optional<Customer> opt = customerDao.findById(id);
        Customer customer = opt.get();
        List<Address> addresses = customer.getAddress();
        return addresses;
    }

    @Override
    public List<Address> updateAddress(Integer id, Integer idx, Address address) {
        Optional<Customer> opt = customerDao.findById(id);
        Customer customer = opt.get();
        List<Address> addresses = customer.getAddress();
//        Address address1 = addresses.get(idx);
        addresses.set(idx, address);
        customerDao.save(customer);
        return addresses;
    }
}
