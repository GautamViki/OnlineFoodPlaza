package com.masai.service;

import com.masai.entity.Address;
import com.masai.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    public List<Address> viewAddress(Integer id);
    public String addAddress(Integer id,Address address);
    public List<Address> updateAddress(Integer id, Integer idx, String city, String state);

//    public String removeAddress(Integer id,Integer idx);

}
