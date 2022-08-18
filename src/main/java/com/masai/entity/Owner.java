package com.masai.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "owner_id")
@Table(name = "owner")
public class Owner extends User{
	
//	@JsonIgnoreProperties("owner")
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Restaurant> restaurants = new ArrayList<>();
//	
//	@JsonIgnoreProperties("login")
//	@OneToOne(cascade = CascadeType.ALL)
//	private User cust;	
//	
//	@JsonIgnoreProperties("user")
//	@OneToOne(cascade = CascadeType.ALL)
//	private Login login;
//
//
//	public LoginStatus getStatus() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

}

