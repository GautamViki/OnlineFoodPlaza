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

    @PutMapping("/{id}/{idx}")
    public List<Address> updateAddressByIdWithIndex(@PathVariable Integer id, @PathVariable Integer idx,
                                                    @RequestBody Address address) {
        return addressService.updateAddress(id, idx, address);
    }
}
