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

import com.masai.entity.Item;

import com.masai.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService iService;

	
	@PostMapping("/")
	public Item addItemHandler(@RequestBody Item item) {
		Item item1= iService.addItem(item);
		if(item1==null){
				throw new NullValueException("Value not found");
		}else {
			return item1;
		}

	}
	
	@GetMapping("/{id}")
	public Item viewItemHandler(@PathVariable("id") Integer id) {
		if (id==null){
			throw new InvalidId("Invalid URI");
		}
		else {
			Item item=iService.viewItem(id);
			if (item==null){
				throw new NullValueException("Value not found");
			}
			return item;
		}

	}
	@DeleteMapping("/{id}")
	public String removeItemHandler(@PathVariable("id")Integer id) {
		if(id==null) {
			throw new InvalidId("Invalid Uri");
		}
		else {
			iService.removeItem(id);
		}
		return "Item deleted";
	}
	@PutMapping("/{id}")
	public Item updateItemHandler(@PathVariable("id")Integer id,@RequestBody Item item) {
		return iService.updateItem(id, item);
	}
	
	@GetMapping("/all")
	public List<Item> viewAllItemHandler(){
		List<Item>items=iService.viewAllItems();
		if(items.size()==0){
			throw new NullValueException("Value not found");
		}
		else {
			return items;
		}
	}
}
