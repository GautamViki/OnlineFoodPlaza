package com.masai.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity

@NoArgsConstructor

public class Customer extends User{
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn (name = "FoodcartId")
//	private Foodcart foodCart;

}