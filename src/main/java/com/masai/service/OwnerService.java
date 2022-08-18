package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.entity.Owner;
import com.masai.entity.UserType;
@Service
public interface OwnerService {
	
		public Owner addOwner(Owner owner, UserType usertype) throws Exception;;
		
		public String removeOwner(Integer Id);
		
		public List<Owner> getAllOwners();
		
		public Owner findByNameAndPassword(String userName, String password);
		
		
}
