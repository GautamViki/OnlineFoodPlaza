package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.entity.Foodcart;
import com.masai.entity.Item;

@Service
public interface FoodCartService {
    public Foodcart addItemToCart(Foodcart cart);
//    public FoodCart inceraseQuantity(FoodCart cart, Item item, int quantity);
//    public FoodCart reduceQuantity(FoodCart cart, Item item, int quantity);
    public String removeItem(Integer cartId);
    public String clearCart();
    
}
