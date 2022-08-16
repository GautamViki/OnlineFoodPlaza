package com.masai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private String userName;
	private String userPwd;
	private String firstName;
	private String lastName;
}
