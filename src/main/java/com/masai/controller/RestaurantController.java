package com.masai.controller;

import java.util.List;
import java.util.Optional;

import com.masai.exception.InvalidId;
import com.masai.exception.NullValueException;
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

import com.masai.entity.Item;
import com.masai.entity.Restaurant;
import com.masai.service.RestaurantService;

@RestController
@RequestMapping("/restaurents")
public class RestaurantController {

	@Autowired
	private RestaurantService rService;
	
	@PostMapping("/")
	public ResponseEntity<Restaurant> addRestaurantHandler(@RequestBody Restaurant restaurant) {
		if(restaurant==null) {
			throw new NullValueException("You have not provided the restaurant to be added");
		}
		
		return new ResponseEntity<Restaurant>(rService.addRestaurant(restaurant),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> viewRestaurantById(@PathVariable("id") Integer id) {
		Restaurant restaurant=rService.viewRestaurant(id);
		if(id==null){
			throw new InvalidId("Invalid Uri");
		}
		
		if (restaurant==null){
			throw  new NullValueException("Order not found");
		}
		return new ResponseEntity<Restaurant>(restaurant,HttpStatus.ACCEPTED);
		

	}
	
	@GetMapping("/rest/{name}")
	public ResponseEntity<List<Restaurant> >viewAllRestautantByNameHandler(@PathVariable("name") String name){
		List<Restaurant>restaurant= rService.viewRestaurantByName(name);
		if(name==null){
			throw new InvalidId("Invalid Uri");
		}else {
			if (restaurant==null){
				throw  new NullValueException("Restaurant not found");
			}
			return new ResponseEntity<List<Restaurant> >(restaurant,HttpStatus.ACCEPTED);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Restaurant> updateRestaurantHandler(@RequestBody Restaurant restaurant, @PathVariable("id") Integer id) {
		if (id == null) {
			throw new InvalidId("Invalid Uri");
		} else {
			Restaurant rest=rService.updateRestaurant(id, restaurant);
			return new ResponseEntity<Restaurant>(rest,HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Restaurant>> viewAllRestaurantHandler(){
		if(rService.viewAllRestaurant()==null) {
			throw  new NullValueException("Restaurants not found");
		}
		List<Restaurant> allRestaurant=rService.viewAllRestaurant();
		return new ResponseEntity<List<Restaurant>>(allRestaurant, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteRestaurantHandler(@PathVariable("id") Integer id) {
		if(id==null) {
			throw new InvalidId("Restaurant with this id does not exists");
		}
		rService.removeRestaurant(id);
		return new ResponseEntity<String>("Restaurant deleted", HttpStatus.ACCEPTED);
	}
}
