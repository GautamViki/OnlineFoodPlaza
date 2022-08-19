package com.masai.controller;

import com.masai.exception.InvalidId;
import com.masai.exception.NullValueException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Bill;
import com.masai.entity.Customer;
//import com.masai.entity.Customer;
import com.masai.service.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {
	@Autowired
	private BillService billService;
	
	@PostMapping("/")
	public ResponseEntity<Bill> saveBill(@RequestBody Bill bill) {
		Bill bill2 = billService.addBill(bill);
		return new ResponseEntity<Bill>(bill,HttpStatus.ACCEPTED);
	}
	

	@PutMapping("/{id}/{totalItem}/{totalCost}")
	public ResponseEntity<Bill>  updateBillHandler(@PathVariable Integer id,
								  @PathVariable Integer totalItem,
								  @PathVariable Double totalCost) {
		if(id==null){
			throw new InvalidId("Invalid URI");
		}
		else {
			Bill bill = billService.updateBill(id, totalItem, totalCost);
			if(bill==null){
				throw new NullValueException("Value not found");
			}
			return new ResponseEntity<Bill>(bill,HttpStatus.ACCEPTED);
		}
	}
		
	   @DeleteMapping("/{id}")
	    public ResponseEntity<String> removeBillHandler(@PathVariable Integer id) {
			if (id==null){
				throw new InvalidId("Invalid URI");
			}
			else{
				Bill bill = billService.removeBill(id);
				if(bill==null){
					throw new NullValueException("Value not found");
				}
				return new ResponseEntity<String>("deleted"+bill,HttpStatus.ACCEPTED);
			}
	    }
	   
	    @GetMapping("/{id}")
	    public ResponseEntity<Bill> viewBillHandler(@PathVariable Integer id) {
			if (id==null){
				throw new InvalidId("Invalid URI");
			}
			else{
				Bill bill=billService.viewBill(id);
				if(bill==null){
					throw new NullValueException("Value not found");
				}
				return new ResponseEntity<Bill>(bill,HttpStatus.ACCEPTED);
			}

	    }
	    
	    @GetMapping("/allBill")
	    public ResponseEntity<List<Bill>> viewAllBillHandler(){
	    	if(billService.viewAllBill()==null) {
	    		throw new NullValueException("Bill not available");
	    	}
			return new ResponseEntity<List<Bill>>(billService.viewAllBill(),HttpStatus.ACCEPTED);
	    	
	    	
	    }
	  
}
    

