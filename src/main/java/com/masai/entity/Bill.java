package com.masai.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer billId;
	@NotNull
	private String billDate;
	@NotNull
	private Integer totalItem;
	@NotNull
	private Double totalCost;
	@OneToOne(cascade = CascadeType.ALL)
	private OrderDetail orderdetail;
	
	
}
