package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Bill;
import com.masai.service.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {
	@Autowired
	private BillService billService;
	
	@PostMapping("/")
	public Bill saveBill(@RequestBody Bill bill) {
		return billService.addBill(bill);
	}
}
