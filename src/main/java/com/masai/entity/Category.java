package com.masai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer catId;
    private String catName;
    
   
	public Integer getCatId() {
		return catId;
	}
	public void setCatId(Integer catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	 
		@Override
		public String toString() {
			return "Category [catId=" + catId + ", catName=" + catName + "]";
		}
}
