package com.masai.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Foodcart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Item> itemList;
	
	public Foodcart() {
		
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "Foodcart [cartId=" + cartId + ", customer=" + customer + ", itemList=" + itemList + "]";
	}
	
}
