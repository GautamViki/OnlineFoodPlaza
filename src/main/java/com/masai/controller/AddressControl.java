package com.masai.controller;

import com.masai.entity.Address;
import com.masai.entity.Customer;
import com.masai.exception.InvalidId;
import com.masai.exception.NullValueException;
import com.masai.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressControl {
    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    public List<Address> getAddress(@PathVariable Integer id){
        if(id==null){
            throw new InvalidId("Invalid Uri");
        }
        else {
            List<Address> addresses=addressService.viewAddress(id);
            if(addresses.size()==0){
                throw new NullValueException("Address not found");
            }
            else {
                return addresses;
            }
        }


    }
    @PostMapping("/{id}")
    public String saveAddress(@PathVariable Integer id,@RequestBody Address address){
        if(id==null){
            throw new InvalidId("Invalid uri");
        }
        else{
            String message= addressService.addAddress(id,address);
            if (message==null || message==""){
                throw new NullValueException("Address not found");
            }
            return message;
        }

    }

    @PutMapping("/{id}/{idx}/{city}/{state}")
    public List<Address> updateAddressByIdWithIndex(@PathVariable Integer id, @PathVariable Integer idx,
                                                    @PathVariable String city, @PathVariable String state) {
        if(id==null||idx==null||city==null||state==null){
            throw new InvalidId("Invalid uri");
        }
        else {
            return addressService.updateAddress(id, idx, city, state);
        }
    }
}
