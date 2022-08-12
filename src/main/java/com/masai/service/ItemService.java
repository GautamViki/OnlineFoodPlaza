package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.entity.Category;
import com.masai.entity.Item;
import com.masai.entity.Restaurant;

@Service
public interface ItemService {
     public Item addItem(Item item);
     public Item updateItem(Item item);
     public Item viewItem(Item item);
     public Item removeItem(Item item);
     public List<Item> viewAllItems(Category cat);
     public List<Item> viewAllItemsByRestaurent(Restaurant res);
     public List<Item> viewAllItemsByName(String name);
     
}
