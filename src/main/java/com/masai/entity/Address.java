package com.masai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	@NotNull
	private String buildingName;
	@NotNull
	private String streetNo;
	@NotNull
	private String area;
	@NotNull
	private String city;
	@NotNull
	private String state;
	@NotNull
	private String country;
	@NotNull
	@Size(min=6,max=6,message="Invalid Pincode")
	@Pattern(regexp="[0-9]{6}",
	message = "Only Valid for 6 digit indian pincode")
	private String pincode;
	

	
	
	
}
