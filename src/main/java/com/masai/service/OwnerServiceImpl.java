package com.masai.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Owner;
import com.masai.entity.UserType;
import com.masai.repository.OwnerDao;
@Service
public class OwnerServiceImpl implements OwnerService{
	@Autowired
	private OwnerDao ownerdao;

	@Override
	public Owner addOwner(Owner owner, UserType userType) throws Exception {
		List<Owner> listOwner = ownerdao.findAll();
        if(listOwner.size()>0) {
        	for(Owner o: listOwner) {
        		
        		if(o.getUserName().equals(owner.getUserName())) {
        			System.out.println("User not available");
        			throw new Exception();
        		}
        	}
        	owner.setUsertype(userType);
        	return ownerdao.save(owner);
        }
        else {
        	owner.setUsertype(userType);
        	return ownerdao.save(owner);
        }
		
	}
	@Override
	public String removeOwner(Integer Id) {
	      Optional<Owner> opt = ownerdao.findById(Id);
	        Owner owner = opt.get();
	        ownerdao.delete(owner);
	        return "Owner Deleted";
	}
	@Override
	public List<Owner> getAllOwners() {
		   List<Owner> owner = ownerdao.findAll();
	        return owner;
		
	}
	@Override
	public Owner findByNameAndPassword(String userName, String password) {
		List<Owner> owner_list = ownerdao.findAll();
		for(Owner owner: owner_list) {
			if(owner.getUserName().equals(userName) && owner.getUserPwd().equals(password)) {
				return owner;
			}
		}
		return null;
	}


	
	

}
