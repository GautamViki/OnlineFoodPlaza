package com.masai.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.entity.Customer;
import com.masai.entity.Login;
import com.masai.entity.LoginStatus;
import com.masai.entity.User;
import com.masai.entity.UserDTO;
import com.masai.repository.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private CustomerService customerService;
	@Override
	public String login(UserDTO custDTO, String UserType)  {
		if(UserType.equalsIgnoreCase("Customer")) {
			List<Login> loginList = loginDao.findAll();
			if(loginList.size()>0) {
				for(Login L: loginList) {
					if(L.getStatus()== LoginStatus.LogedIn) {
						System.out.println("Already Logged In");
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
				System.out.println("Insert Valid User and Password");
//				throw new Exception();
			}
		}
		
		else if(UserType.equalsIgnoreCase("Owner")) {
			System.out.println("xyz");
		}
		return null;
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

}
