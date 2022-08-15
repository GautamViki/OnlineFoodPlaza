package com.masai.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	  private Integer itemId;
	  private String itemName;
	  private Integer quantity;
	  private Double cost;
  
  @OneToOne(cascade = CascadeType.ALL)
  private Category cat;
  
  @ManyToMany(cascade = CascadeType.ALL, mappedBy = "items")
  @JsonIgnore
  private List<Restaurant> restaurant;

public Integer getItemId() {
	return itemId;
}

public void setItemId(Integer itemId) {
	this.itemId = itemId;
}

public String getItemName() {
	return itemName;
}

public void setItemName(String itemName) {
	this.itemName = itemName;
}

public Integer getQuantity() {
	return quantity;
}

public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}

public Double getCost() {
	return cost;
}

public void setCost(Double cost) {
	this.cost = cost;
}

public Category getCat() {
	return cat;
}

public void setCat(Category cat) {
	this.cat = cat;
}

public List<Restaurant> getRestaurant() {
	return restaurant;
}

public void setRestaurant(List<Restaurant> restaurant) {
	this.restaurant = restaurant;
}

@Override
public String toString() {
	return "Item [itemId=" + itemId + ", itemName=" + itemName + ", quantity=" + quantity + ", cost=" + cost + ", cat="
			+ cat + ", restaurant=" + restaurant + "]";
}
  
  
  
}
