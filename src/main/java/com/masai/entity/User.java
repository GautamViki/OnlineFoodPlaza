package com.masai.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
	@NotNull(message = "User type should not be null")
	private UserType usertype;
	@NotNull(message = "UserName should not be null")
	private String userName;
	@NotNull(message = "password should not be null")
	private String userPwd;
	@NotNull(message = "First name should not be null")
	private String firstName;
	@NotNull(message = "Last name should not be null")
	private String lastName;
	@NotNull(message = "age should not be null")
	private Integer age;
	@NotNull(message = "gender should not be null")
	private String gender;
	@Pattern(regexp = "[0-9]{10}", message = "Mobile number must have 10 digits")
	private String mobileNumber;
	@OneToMany(cascade = CascadeType.ALL)
	List<Address> address=new ArrayList<>();
	@NotNull(message = "email should not be null")
	@Email
	private String email;
}