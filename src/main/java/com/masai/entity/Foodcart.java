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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Foodcart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
//	@OneToOne(cascade = CascadeType.ALL)
//	private Customer customer;
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Item> itemList;
	

	
}
