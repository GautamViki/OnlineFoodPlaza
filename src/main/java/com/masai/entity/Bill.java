package com.masai.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer billId;
	private String billDate;
	private Integer totalItem;
	private Double totalCost;
	@OneToOne(cascade = CascadeType.ALL)
	private OrderDetail orderdetail;
	public Bill() {
		
	}
	public Integer getBillId() {
		return billId;
	}
	public void setBillId(Integer billId) {
		this.billId = billId;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public Integer getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	public OrderDetail getOrderdetail() {
		return orderdetail;
	}
	public void setOrderdetail(OrderDetail orderdetail) {
		this.orderdetail = orderdetail;
	}
	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billDate=" + billDate + ", totalItem=" + totalItem + ", totalCost="
				+ totalCost + ", orderdetail=" + orderdetail + "]";
	}

	
	
}
