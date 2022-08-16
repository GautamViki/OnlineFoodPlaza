package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Foodcart;
import com.masai.entity.Item;
import com.masai.repository.CustomerDao;
import com.masai.repository.FoodcartDao;
import com.masai.repository.ItemDao;

@Service
public class FoodCartServiceImpl implements FoodCartService{

	@Autowired
	private FoodcartDao foodDao;
	@Autowired
	private CustomerDao cDao;
	@Autowired
	private ItemDao iDao;
	
	@Override
	public Foodcart addItemToCart(Foodcart cart) {
//		cDao.save(cart.getCustomer());
		
		List<Item> items=cart.getItemList();
		for(Item i:items) {
			iDao.save(i);
		}
		foodDao.save(cart);
		return null;
	}

	@Override
	public String removeItem(Integer cartId, Integer itemId) {
		Optional<Foodcart> fCart=foodDao.findById(cartId);
		Foodcart foodCart=fCart.get();
		
		return null;
	}

	@Override
	public String clearCart(Foodcart cart) {
		// TODO Auto-generated method stub
		return null;
	}



}
