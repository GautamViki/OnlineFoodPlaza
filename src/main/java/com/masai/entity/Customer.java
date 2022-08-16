package com.masai.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	private String mobileNumber;
	@OneToMany(cascade = CascadeType.ALL)
	List<Address> address=new ArrayList<>();
	private String email;
//	/**
//	 * @param customerId
//	 * @param firstName
//	 * @param lastName
//	 * @param age
//	 * @param gender
//	 * @param mobileNumber
//	 * @param address
//	 * @param email
//	 */
	public Customer() {
		
	}
//	public Customer(Integer customerId, String firstName, String lastName, Integer age, String gender,
//			String mobileNumber, Address address, String email) {
//		super();
//		this.customerId = customerId;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.age = age;
//		this.gender = gender;
//		this.mobileNumber = mobileNumber;
//		this.address = address;
//		this.email = email;
//	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", address=" + address + ", email="
				+ email + "]";
	}
	
	
}
