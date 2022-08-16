package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Address;
import com.masai.entity.Item;
import com.masai.entity.Restaurant;
import com.masai.repository.AddressDao;
import com.masai.repository.ItemDao;
import com.masai.repository.RestaurantDao;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private AddressDao aDao;
	
	@Autowired
	private ItemDao iDao;
	
	@Autowired
	private RestaurantDao rDao;

	@Override
	public Restaurant addRestaurant(Restaurant res) {
		
		List<Item> item=res.getItems();
		for(Item i:item) {
//			i.getRestaurant().add(res);
			iDao.save(i);
		}
		aDao.save(res.getAddress());
		return rDao.save(res);
		
	}


	@Override
	public Restaurant viewRestaurant(Integer id) {
		Optional<Restaurant> rest = rDao.findById(id);
		return rest.get();
	}


	@Override
	public List<Restaurant> viewRestaurantByName(String name) {
		List<Restaurant> allRests=rDao.findAll();
		List<Restaurant> restsByName= new ArrayList<>();
		for(Restaurant res:allRests) {
			if(res.getResName().equals(name)) {
				restsByName.add(res);
			}
		}
		return restsByName;
	}


	@Override
	public Restaurant updateRestaurant(Integer id, Restaurant res) {
		Optional<Restaurant> rest = rDao.findById(id);
		res.setResId(id);
		rDao.save(res);
		return res;
	}


	@Override
	public String removeRestaurant(Integer id) {
		rDao.deleteById(id);
		return "Deleted";
	}


	@Override
	public List<Restaurant> viewAllRestaurant() {
		List<Restaurant> allrests=rDao.findAll();
		
		
		return allrests;
	}

}
