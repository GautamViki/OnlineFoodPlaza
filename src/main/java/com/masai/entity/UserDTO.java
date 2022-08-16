package com.masai.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	@NotNull
	@Pattern(regexp="[a-z]{6,12}",
	message = "Username must be between 6 to 12 characters. Must only contain lowercase characters.")
	private String userName;
	@Pattern(regexp="[a-zA-Z0-9]{6,12}",
	message="Password must contain between 6 to 12 characters. Must be alphanumeric with both Upper and lowercase characters.")
	private String userPwd;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
}