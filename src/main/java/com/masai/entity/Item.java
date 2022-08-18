package com.masai.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	  private Integer itemId;
	  @NotNull
	  private String itemName;
	  @NotNull
	  private Integer quantity;
	  @NotNull
	  private Double cost;
  
  @OneToOne(cascade = CascadeType.ALL)
  private Category cat;
  
//  @(cascade = CascadeType.ALL, mappedBy = "items")
//  @JsonIgnoreProperties("restaurant")
//  
//  private List<Restaurant> restaurant;  
  
}