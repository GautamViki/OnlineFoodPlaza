package com.masai.controller;


import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PutMapping("/{id}/{order}")
	public OrderDetail updateOrderHandler(@PathVariable Integer id,
								  @PathVariable OrderDetail order) {
		OrderDetail order1 = orderService.updateOrder(id, order);
		return order1;
	}
	
	@PostMapping("/")
	public OrderDetail saveOrderHandler(@RequestBody OrderDetail order) {
		return orderService.addOrder(order);
	}
	
	   @DeleteMapping("/{id}")
	    public String removeOrderHandler(@PathVariable Integer id) {
	        String order = orderService.removeOrder(id);
	        return "Deleted " + order;
	    }
	   
	    @GetMapping("/{id}")
	    public OrderDetail viewOrderHandler(@PathVariable Integer id) {
	        return orderService.viewOrder(id);
	    }
}
