package com.masai.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor

public class Customer extends User{
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "FoodcartId")
	private Foodcart foodCart;
	

}