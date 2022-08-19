package com.masai.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.masai.entity.Item;

@Service
public interface ItemService {
     public Item addItem(Integer resid ,Item item);
     public Item updateItem(Integer id, Item item);
     public Item viewItem(Integer id);
     public String removeItem(Integer id);
     public List<Item> viewAllItems();
     public List<Item> viewAllItemsByCategory(String  catName);
     public List<Item> viewItemsByRestaurent(String resName,String itemName);
     public List<Item> viewAllItemsByName(String name);
     
}
