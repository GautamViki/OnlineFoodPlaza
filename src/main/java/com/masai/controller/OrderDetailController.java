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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.masai.entity.OrderDetail;
import com.masai.service.OrderDetailsService;

@RestController
@RequestMapping("/order")
public class OrderDetailController {
	
	@Autowired
	private OrderDetailsService orderService;
	
	@PutMapping("/{id}")
	public ResponseEntity<OrderDetail> updateOrderHandler(@PathVariable Integer id,
								  @RequestBody OrderDetail order) {
		if(id==null){
			throw new InvalidId("Invalid Uri");
		}else {
			OrderDetail order1 = orderService.updateOrder(id, order);
			if (order1==null){
				throw  new NullValueException("Order not found");
			}
			return new ResponseEntity<OrderDetail>(order1,HttpStatus.ACCEPTED);
		}

	}
	
	@PostMapping("/")
	public ResponseEntity<OrderDetail> saveOrderHandler(@RequestBody OrderDetail order) {
		return new ResponseEntity<OrderDetail>(orderService.addOrder(order),HttpStatus.ACCEPTED);
	}
	
	   @DeleteMapping("/{id}")
	    public ResponseEntity<String> removeOrderHandler(@PathVariable Integer id) {
		   if(id==null){
			   throw new InvalidId("Invalid Uri");
		   }else {
			   String order = orderService.removeOrder(id);
			   if (order==null){
				   throw  new NullValueException("Order not found");
			   }
			   return new ResponseEntity<String>("Deleted " + order,HttpStatus.ACCEPTED);
		   }

	    }
	   
	    @GetMapping("/{id}")
	    public ResponseEntity<OrderDetail> viewOrderHandler(@PathVariable Integer id) {
			if(id==null){
				throw new InvalidId("Invalid Uri");
			}else {
				OrderDetail order1=orderService.viewOrder(id);
				if (order1==null){
					throw  new NullValueException("Order not found");
				}
				return  new ResponseEntity<OrderDetail>(order1,HttpStatus.ACCEPTED);
			}

	    }
	    
	    
	    @GetMapping("/all")
	    public ResponseEntity<List<OrderDetail>> viewAllOrderHandler() {
			
				List<OrderDetail> order1=orderService.viewAllOrder();
				if (order1==null){
					throw  new NullValueException("Order not found");
				}
				return new ResponseEntity<List<OrderDetail>>(order1,HttpStatus.ACCEPTED);
			

	    }
	    
	    
	    
}
