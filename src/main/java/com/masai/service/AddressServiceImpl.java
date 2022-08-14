package com.masai.service;

import com.masai.entity.Address;
import com.masai.repository.AddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService{
@Autowired
    private AddressDao addressDao;

    @Override
    public Address viewAddress(Integer id) {
        Optional<Address> opt = addressDao.findById(id);
        Address address = opt.get();
        return address;
    }
}
