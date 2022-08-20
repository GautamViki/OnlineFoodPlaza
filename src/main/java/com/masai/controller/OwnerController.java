package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Owner;
import com.masai.entity.UserType;
import com.masai.exception.NullValueException;
import com.masai.service.OwnerService;
@RestController
@RequestMapping("/Owner")
public class OwnerController {
	@Autowired
	private OwnerService ownerService;
	
	 @PostMapping("/")
	    public ResponseEntity<Owner> saveOwnerHandler(@RequestBody Owner owner) throws Exception {
		 return new ResponseEntity<Owner>(ownerService.addOwner(owner, UserType.Owner),HttpStatus.ACCEPTED);
	    }


	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> removeOwnerHandler(@PathVariable Integer id) {
	    	if(id==null) {
	    		throw new NullPointerException("Id is invalid");
	    	}
	        String owner = ownerService.removeOwner(id);
	        return new ResponseEntity<String>("Deleted " + owner,HttpStatus.OK);
	    }

	    
	    @GetMapping("/allOwner")
		public ResponseEntity<List<Owner>> getAllOwner(){
	    	if(ownerService.getAllOwners()==null) {
				throw  new NullValueException("Owner not found");
			}
			return new ResponseEntity<List<Owner>>(ownerService.getAllOwners(),HttpStatus.ACCEPTED);
		}
}
