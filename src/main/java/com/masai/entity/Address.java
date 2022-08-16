package com.masai.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;

	@NotNull(message = "building should not be null")
	private String buildingName;

	@NotNull(message = "street should not be null")
	private String streetNo;

	@NotNull(message = "area should not be null")
	private String area;

	@NotNull(message = "city should not be null")
	private String city;

	@NotNull(message = "state should not be null")
	private String state;

	@NotNull(message = "country should not be null")
	private String country;

	@NotNull
	@Size(min = 6, max = 6, message = "Invalid Pin code")
	@Pattern(regexp = "[0-9]{6}", message = "Only Valid for 6 digit indian pin code")
	private String pincode;

	@ManyToOne(cascade=CascadeType.ALL)
	@JsonIgnoreProperties("addresses")
	@JsonIgnore
	private User user;

//	public User getUser() {
//		return user;
//	}

//	public void setUser(User user) {
//		this.user = user;
//	}

	public Address() {
		
	}

	public Integer getAddressId() {
		return addressId;
	}


	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}


	public String getBuildingName() {
		return buildingName;
	}


	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}


	public String getStreetNo() {
		return streetNo;
	}


	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", buildingName=" + buildingName + ", streetNo=" + streetNo
				+ ", area=" + area + ", city=" + city + ", state=" + state + ", country=" + country + ", pincode="
				+ pincode + "]";
	}
}
