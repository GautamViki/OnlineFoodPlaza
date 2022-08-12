package com.masai.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Item {
	@Id
    private String itemId;
    private String itemName;
    private Category category;
    private Integer quanytity;
    private Double cost;
    
    @OneToOne
    private List<Restaurant> resturaunt;
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
	public Integer getQuanytity() {
		return quanytity;
	}
	public void setQuanytity(Integer quanytity) {
		this.quanytity = quanytity;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public List<Restaurant> getResturaunt() {
		return resturaunt;
	}
	public void setResturaunt(List<Restaurant> resturaunt) {
		this.resturaunt = resturaunt;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", quanytity=" + quanytity + ", cost=" + cost
				+ "]";
	}
    
    
    
}
