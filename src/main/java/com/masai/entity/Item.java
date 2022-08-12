package com.masai.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Item {
	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
    strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
	
    private String itemId;
    private String itemName;
    @OneToOne(cascade = CascadeType.ALL)
    private Category category;
    private Integer quantity;
    private Double cost;

    


	@ManyToMany(cascade = CascadeType.ALL)
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
