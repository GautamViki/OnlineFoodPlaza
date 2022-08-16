package com.masai.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
  
  @ManyToMany(cascade = CascadeType.ALL, mappedBy = "items")
//  @JsonIgnore
  private List<Restaurant> restaurant;  
  
}