package com.masai.service;

import com.masai.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    public List<Address> viewAddress(Integer id);
    public List<Address> updateAddress(Integer id, Integer idx, Address address);
}
