package com.masai.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
	private Integer Id;
	
	private UserType usertype;
	@NotNull
	@Pattern(regexp="[a-z]{6,12}",
	message = "Username must be between 6 to 12 characters. Must only contain lowercase characters.")
	private String userName;
	@NotNull
	@Pattern(regexp="[a-zA-Z0-9]{6,12}",message="Password must contain between 6 to 12 characters."
			+ " Must be alphanumeric with both Upper and lowercase characters.")
	private String userPwd;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private Integer age;
	@NotNull
	private String gender;
	@NotNull
	@Pattern(regexp="[0-9]{10}", message = "Mobile number must have 10 digits")
	private String mobileNumber;
	@OneToMany(cascade = CascadeType.ALL)
	List<Address> address=new ArrayList<>();
	private String email;
}