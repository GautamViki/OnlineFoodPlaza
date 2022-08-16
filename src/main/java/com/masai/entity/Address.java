package com.masai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	@NotNull(message = "building shouldn't be empty")
	private String buildingName;
	@NotNull(message = "streetNo shouldn't be empty")
	private String streetNo;
	@NotNull(message = "area shouldn't be empty")
	private String area;
	@NotNull(message = "city shouldn't be empty")
	private String city;
	@NotNull(message = "state shouldn't be empty")
	private String state;
	@NotNull(message = "country shouldn't be empty")
	private String country;
	@NotNull
	@Size(min=6,max=6,message="Invalid Pincode")
	@Pattern(regexp="[0-9]{6}", message = "Only Valid for 6 digit indian pincode")
	private String pincode;
	

	public Address() {
		
	}


//	public Address(Integer addressId, String buildingName, String streetNo, String area, String city, String state,
//			String country, String pincode) {
//		this.addressId = addressId;
//		this.buildingName = buildingName;
//		this.streetNo = streetNo;
//		this.area = area;
//		this.city = city;
//		this.state = state;
//		this.country = country;
//		this.pincode = pincode;
//	}


	

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
