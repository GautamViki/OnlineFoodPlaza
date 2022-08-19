package com.masai.controller;

import java.util.List;

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

import com.masai.service.ItemService;

import io.swagger.models.Response;

@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService iService;

	
	@PostMapping("/{resId}")
	public ResponseEntity<String> addItemHandler(@PathVariable("resId") Integer id, @RequestBody Item item) {
		Item item1= iService.addItem(id, item);
		if(item1==null){
				throw new NullValueException("Value not found");
		}else {
			return new ResponseEntity<String>("Item Added "+item1 , HttpStatus.ACCEPTED) ;
		}

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> viewItemHandler(@PathVariable("id") Integer id) {
		if (id==null){
			throw new InvalidId("Invalid URI");
		}
		else {
			Item item=iService.viewItem(id);
			if (item==null){
				throw new NullValueException("Value not found");
			}
			return new ResponseEntity<String>("Item "+item, HttpStatus.ACCEPTED);
		}

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeItemHandler(@PathVariable("id")Integer id) {
		if(id==null) {
			throw new InvalidId("Invalid Uri");
		}
		
		String message=iService.removeItem(id);
		
		return new ResponseEntity<String>("Item "+ message,HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateItemHandler(@PathVariable("id")Integer id,@RequestBody Item item) {
		Item item1= iService.updateItem(id, item);
		ResponseEntity<String> response=new ResponseEntity<String>("Item "+item1,HttpStatus.ACCEPTED);
		return response;
	}
	
	@GetMapping("/all")
	public ResponseEntity<String> viewAllItemHandler(){
		List<Item>items=iService.viewAllItems();
		if(items.size()==0){
			throw new NullValueException("Value not found");
		}
		else {
			return new ResponseEntity<String>(""+items,HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/allItemByName/{itemName}")
	public ResponseEntity<List<Item>> viewAllItemsByNameHandler(@PathVariable("itemName") String name){
		List<Item>items=iService.viewAllItemsByName(name);
		if(items.size()==0){
			throw new NullValueException("Item with name "+name +" is not found");
		}
		else {
			return new ResponseEntity<List<Item>>(items,HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/all/item/restaurant/Name/{restName}/{itemName}")
	public ResponseEntity<List<Item>> viewAllItemsByRestaurentHandler(@PathVariable("restName") String name,@PathVariable("itemName") String itemName){
		List<Item>items=iService.viewItemsByRestaurent(name,itemName);
		if(items.size()==0){
			throw new NullValueException("Item  "+name +" is not found");
		}
		else {
			return new ResponseEntity<List<Item>>(items,HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/all/item/category/Name/{catName}")
	public ResponseEntity<List<Item>> viewAllItemsByCategoryHandler(@PathVariable("catName") String name){
		List<Item>items=iService.viewAllItemsByCategory(name);
		if(items.size()==0){
			throw new NullValueException("Item with category "+name +" is not found");
		}
		else {
			return new ResponseEntity<List<Item>>(items,HttpStatus.ACCEPTED);
		}
	}
}
