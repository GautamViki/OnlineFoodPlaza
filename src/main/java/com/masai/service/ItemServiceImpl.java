package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Item;
import com.masai.entity.Restaurant;
import com.masai.repository.CategoryDao;
import com.masai.repository.ItemDao;
import com.masai.repository.RestaurantDao;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private CategoryDao cDao;
	
	@Autowired
	private RestaurantDao rDao;
	
	@Autowired
	private ItemDao iDao;

	@Override
	public Item addItem(Item item) {
		
		
		List<Restaurant> res=item.getRestaurant();
		for(Restaurant r:res) {
//			r.getItems().add(item);
			rDao.save(r);
		}
		cDao.save(item.getCat());
		return iDao.save(item);
	}

	@Override
	public Item updateItem(Integer id, Item item) {
		Optional<Item> items = iDao.findById(id);
		item.setItemId(id);
		iDao.save(item);
		return item;
	}

	@Override
	public Item viewItem(Integer id) {
		Optional<Item> opt = iDao.findById(id);
		return opt.get();
	}

	@Override
	public String removeItem(Integer id) {
		iDao.deleteById(id);
		return "Deleted";
	}

	@Override
	public List<Item> viewAllItems() {
		List<Item> items=iDao.findAll();
		return items;
	}
//
//	@Override
//	public List<Item> viewAllItemsByRestaurent(Restaurant res) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
	public List<Item> viewAllItemsByName(String name) {
		List<Item> items=iDao.findAll();
		List<Item> item1=new ArrayList<>();
		for(Item item:items) {
			if(item.getItemName().equals(name)) {
				item1.add(item);
			}
		}
		return item1;
	}

}
