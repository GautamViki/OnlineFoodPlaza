package com.masai.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.entity.Customer;
import com.masai.entity.Login;
import com.masai.entity.LoginStatus;
import com.masai.entity.Owner;
import com.masai.entity.User;
import com.masai.entity.UserDTO;
import com.masai.exception.InvalidId;
import com.masai.repository.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OwnerService ownerservice;
	@Override
	public String login(UserDTO custDTO, String UserType)  {
		if(UserType.equalsIgnoreCase("Customer")) {
			List<Login> loginList = loginDao.findAll();
			if(loginList.size()>0) {
				for(Login L: loginList) {
					if(L.getStatus()== LoginStatus.LogedIn) {
						throw new InvalidId("Already Logged In");
					}
				}
			}
			Customer customer = customerService.findByNameAndPassword(custDTO.getUserName(), custDTO.getUserPwd());
			if(customer != null) {
				Login newLogin = new Login();
				newLogin.setApiKey(UUID.randomUUID().toString().replaceAll("-", "").substring(0,10));
				newLogin.setStatus(LoginStatus.LogedIn);
				
				newLogin.setUser(customer);
				loginDao.save(newLogin);
				return "You are successfully login";
			}else {
				throw new InvalidId("Insert Valid User and Password");
//				throw new Exception();
			}
		}
		else if(UserType.equalsIgnoreCase("Owner")) {
			List<Login> loginList = loginDao.findAll();
			if(loginList.size()>0) {
				for(Login L: loginList) {
					if(L.getStatus()== LoginStatus.LogedIn) {
						throw new InvalidId("Already Logged In");
					}
				}
			}
			Owner owner = ownerservice.findByNameAndPassword(custDTO.getUserName(), custDTO.getUserPwd());
			if(owner != null) {
				Login newLogin = new Login();
				newLogin.setApiKey(UUID.randomUUID().toString().replaceAll("-", "").substring(0,10));
				newLogin.setStatus(LoginStatus.LogedIn);
				
				newLogin.setUser(owner);
				loginDao.save(newLogin);
				return "You are successfully login";
			}else {
				throw new InvalidId("Insert Valid User and Password");
//				throw new Exception();
			}
		}
		else {
			return null;
		}
		
		
		
	}

	@Override
	public String logout() {
		List<Login> loginList = loginDao.findAll();
		for(Login l : loginList) {
			
			l.setStatus(LoginStatus.LogedOut);
		}
		loginDao.saveAll(loginList);
		return "Successfully Logout";
		
	}

	@Override
	public User loginDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String login_owner(UserDTO OwnerDTO, String UserType) {
		if(UserType.equalsIgnoreCase("Owner")) {
			List<Login> loginList = loginDao.findAll();
			if(loginList.size()>0) {
				for(Login L: loginList) {
					if(L.getStatus()== LoginStatus.LogedIn) {
						System.out.println("Already Logged In");
					}
				}
			}
			Owner owner = ownerservice.findByNameAndPassword(OwnerDTO.getUserName(), OwnerDTO.getUserPwd());
			if(owner != null) {
				Login newLogin = new Login();
				newLogin.setApiKey(UUID.randomUUID().toString().replaceAll("-", "").substring(0,10));
				newLogin.setStatus(LoginStatus.LogedIn);
				
				newLogin.setUser(owner);
				loginDao.save(newLogin);
				return "You are successfully login";
			}else {
				throw new InvalidId("Insert Valid User and Password");
//				throw new Exception();
			}
		}return null;
		
	}

}
