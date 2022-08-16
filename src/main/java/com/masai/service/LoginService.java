package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.entity.User;
import com.masai.entity.UserDTO;

@Service
public interface LoginService {
	
	public String login(UserDTO custDTO, String UserType);
	
	public String login_owner(UserDTO OwnerDTO, String UserType);
	
	public String logout();
	
	public User loginDetail();
}
