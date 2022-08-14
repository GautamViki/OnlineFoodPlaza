package com.masai.service;

import com.masai.entity.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    public Address viewAddress(Integer id);

}
