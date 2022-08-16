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
	@NotNull(message = "building should not be null")
	private String buildingName;
	@NotNull(message = "Street number should not be null")
	private String streetNo;
	@NotNull(message = "Area should not be null")
	private String area;
	@NotNull(message = "City should not be null")
	private String city;
	@NotNull(message = "State should not be null")
	private String state;
	@NotNull(message = "Country should not be null")
	private String country;
	@NotNull(message = "Pin code should not be null")
	@Pattern(regexp = "[0-9]{6}", message = "Only Valid for 6 digit indian pin code")
	private String pincode;
}