package com.masai.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Customer extends User{
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "FoodcartId")
	private Foodcart foodCart;
	


}