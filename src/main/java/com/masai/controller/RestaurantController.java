package com.masai.controller;

import java.util.List;

import com.masai.exception.InvalidId;
import com.masai.exception.NullValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Restaurant;
import com.masai.service.RestaurantService;

@RestController
@RequestMapping("/restaurents")
public class RestaurantController {

	@Autowired
	private RestaurantService rService;
	
	@PostMapping("/")
	public Restaurant addRestaurantHandler(@RequestBody Restaurant restaurant) {
		return rService.addRestaurant(restaurant);
	}
	
	@GetMapping("/{id}")
	public Restaurant viewRestaurantById(@PathVariable("id") Integer id) {
		Restaurant restaurant=rService.viewRestaurant(id);
		if(id==null){
			throw new InvalidId("Invalid Uri");
		}
		
		if (restaurant==null){
			throw  new NullValueException("Order not found");
		}
		return restaurant;
		

	}
	
	@GetMapping("/rest/{name}")
	public List<Restaurant> viewAllRestautantByNameHandler(@PathVariable("name") String name){
		List<Restaurant>restaurant= rService.viewRestaurantByName(name);
		if(name==null){
			throw new InvalidId("Invalid Uri");
		}else {
			
			if (restaurant==null){
				throw  new NullValueException("Order not found");
			}
			return restaurant;
		}
	}
	
	@PutMapping("/{id}")
	public Restaurant updateRestaurantHandler(@RequestBody Restaurant restaurant, @PathVariable("id") Integer id) {
		if (id == null) {
			throw new InvalidId("Invalid Uri");
		} else {
			return rService.updateRestaurant(id, restaurant);
		}
	}
	
	@GetMapping("/")
	public List<Restaurant> viewAllRestaurantHandler(){
		
		return rService.viewAllRestaurant();
	}
	
	@DeleteMapping("{id}")
	public String deleteRestaurantHandler(@PathVariable("id") Integer id) {
		rService.removeRestaurant(id);
		return "Restaurant deleted";
	}
}
