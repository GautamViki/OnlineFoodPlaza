package com.masai.controller;

import com.masai.entity.Address;
import com.masai.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressControl {
    @Autowired
    private AddressService addressService;

    @PutMapping("/{id}/{idx}/{city}/{state}")
    public List<Address> updateAddressByIdWithIndex(@PathVariable Integer id, @PathVariable Integer idx,
                                                    @PathVariable String city, @PathVariable String state) {
        return addressService.updateAddress(id, idx, city, state);
    }
}
