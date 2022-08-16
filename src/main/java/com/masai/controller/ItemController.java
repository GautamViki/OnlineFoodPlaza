package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	
	@PostMapping("")
	public Item addItemHandler(@RequestBody Item item) {
		return iService.addItem(item);
	}
	
	@GetMapping("/{id}")
	public Item viewItemHandler(@PathVariable("id") Integer id) {
		return iService.viewItem(id);
	}
	
	@GetMapping("")
	public List<Item> viewAllItemHandler(){
		return iService.viewAllItems();
	}
	
}
