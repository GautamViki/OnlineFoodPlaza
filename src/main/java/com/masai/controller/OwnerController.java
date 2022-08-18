package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Owner;
import com.masai.entity.UserType;
import com.masai.service.OwnerService;
@RestController
@RequestMapping("/Owner")
public class OwnerController {
	@Autowired
	private OwnerService ownerService;
	
	 @PostMapping("/")
	    public Owner saveOwnerHandler(@RequestBody Owner owner) throws Exception {
//	        return ownerService.addOwner(custDTO,UserType.Owner);
		 return ownerService.addOwner(owner, UserType.Owner);
	    }


	    @DeleteMapping("/{id}")
	    public String removeOwnerHandler(@PathVariable Integer id) {
	        String owner = ownerService.removeOwner(id);
	        return "Deleted " + owner;
	    }

	    
	    @GetMapping("/allOwner")
		public List<Owner> getAllOwner(){
			return ownerService.getAllOwners();
		}
}
