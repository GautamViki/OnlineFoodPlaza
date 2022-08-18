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
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
     private Integer resId;
	 @NotNull
     private String resName;
     private String managerName;
     
     @OneToOne(cascade = CascadeType.ALL)
     private Address address;
     
     @ManyToMany(cascade = CascadeType.ALL)
//     @JsonIgnore
     private List<Item> items;


     
}