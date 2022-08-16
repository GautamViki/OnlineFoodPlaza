package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.CustomerDTO;

@RestController
public class LoginController {

//	@Autowired
//	private CustomerLogInImpl customerLogInImpl;
//	
//	@PostMapping(value = "/login")
//	public String logInCustomer(@RequestBody CustomerDTO customerDTO ) {
//		return customerLogInImpl.logIntoAccount(customerDTO);
//		
//	}
//	
//	@PatchMapping(value = "/logout")
//	public String logInCustomer(@RequestParam(required = false) String key ) {
//		return customerLogInImpl.logOutFromAccount(key);
//		
//	}
	
}
