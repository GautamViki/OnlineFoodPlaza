package com.masai.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private String orderDate;
	@OneToOne(cascade = CascadeType.ALL)
	private Foodcart cart;
	private String orderStatus;
	@OneToOne(cascade = CascadeType.ALL)
	private Bill bill;
	public OrderDetail() {
		
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Foodcart getCart() {
		return cart;
	}

	public void setCart(Foodcart cart) {
		this.cart = cart;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderId=" + orderId + ", orderDate=" + orderDate + ", cart=" + cart + ", orderStatus="
				+ orderStatus + "]";
	}


	
	
}
