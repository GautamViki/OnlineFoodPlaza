package com.masai.controller;

import com.masai.entity.Address;
import com.masai.entity.Customer;
import com.masai.entity.User;
import com.masai.service.AddressService;
import com.masai.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressControl {
    @Autowired
    private AddressService addressService;
@Autowired
    private CustomerService customerService;
@PostMapping("/{id}")
    public String addAddress(@RequestBody Address address,@PathVariable Integer id) throws Exception {

        return addressService.addAddress(id,address);
    }
    @GetMapping("/{id}")
    public List<Address> viewAddressHandler(@PathVariable Integer id) {
        return addressService.viewAddress(id);
    }
    @PutMapping("/{id}/{idx}")
    public List<Address> updateAddressByIdWithIndex(@PathVariable Integer id, @PathVariable Integer idx,
                                                    @RequestBody Address address) {
        return addressService.updateAddress(id, idx, address);
    }
}
