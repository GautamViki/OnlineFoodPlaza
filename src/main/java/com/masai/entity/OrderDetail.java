package com.masai.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	private LocalDateTime orderDate=LocalDateTime.now();
	@OneToOne(cascade = CascadeType.ALL)
	private Foodcart cart;
	
	private String orderStatus;
	@OneToOne(cascade = CascadeType.ALL)
	private Bill bill;
}
	
	
