package com.masai.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer customerId;
	private UserType usertype;
	private String userName;
	private String userPwd;
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	private String mobileNumber;
	@JsonIgnoreProperties("user")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address;
	private String email;
}
