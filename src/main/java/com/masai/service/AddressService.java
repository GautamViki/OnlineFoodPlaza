package com.masai.service;

import com.masai.entity.Address;
import com.masai.entity.Customer;
import com.masai.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AddressService {
    public String addAddress(Integer id,Address address) throws Exception;
    public List<Address> viewAddress(Integer id);
    public List<Address> updateAddress(Integer id, Integer idx, Address address);
}
