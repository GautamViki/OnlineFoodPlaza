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

	private String userPwd;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
}