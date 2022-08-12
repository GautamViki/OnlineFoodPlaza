package com.masai.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


@Entity
public class Item {
	@Id
    private String itemId;
    private String itemName;
    private Category category;
    private Integer quantity;
    private Double cost;

    


	@ManyToMany
	private List<Restaurant> restaurants;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}




	public String getItemName() {
		return itemName;
	}




	public void setItemName(String itemName) {
		this.itemName = itemName;
	}




	public Category getCategory() {
		return category;
	}




	public void setCategory(Category category) {
		this.category = category;
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




	public List<Restaurant> getRestaurants() {
		return restaurants;
	}




	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}




	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", category=" + category + ", quantity=" + quantity
				+ ", cost=" + cost + ", restaurants=" + restaurants + "]";
	}

	
	
}
