package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Item;
import com.masai.entity.Restaurant;
import com.masai.exception.InvalidId;
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
	public Item addItem(Integer resid,Item item) {
		
		Optional<Restaurant> opt=rDao.findById(resid);
		if(opt.isPresent()) {
			opt.get().getItems().add(item);
			rDao.save(opt.get());
			return item;
		}
		else {
			throw new InvalidId("Restaurant does not exist");
		}
//		cDao.save(item.getCat());
//		return iDao.save(item);
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

	@Override
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

	@Override
	public List<Item> viewAllItemsByCategory(String catName) {
		List<Item> allItems=iDao.findAll();
		List<Item> itemByCat= new ArrayList<>();
		for(Item item: allItems) {
			if(item.getCat().getCategoryName().equalsIgnoreCase(catName)) {
				itemByCat.add(item);
			}
		}
		
		
		return itemByCat;
	}

	@Override
	public List<Item> viewItemsByRestaurent(String resName,String itemName) {
		List<Restaurant> allRests=rDao.findAll();
		List<Item> itemsByRests= new ArrayList<>();
		for(Restaurant res: allRests) {
			if(res.getResName().equalsIgnoreCase(resName)) {
				List<Item> i=res.getItems();
				for(Item item2: i) {
					if(item2.getItemName().equalsIgnoreCase(itemName)) {
						itemsByRests.add(item2);
					}
				}
				
			}
		}
		return itemsByRests;
	}

}
