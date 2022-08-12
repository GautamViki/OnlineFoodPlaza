package com.masai.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
    private String catId;
    private String catName;
    
   
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
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
