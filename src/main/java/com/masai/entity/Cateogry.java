package com.masai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cateogry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer catId;
	private String categoryName;
	
	public Cateogry() {
		
	}

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Cateogry [catId=" + catId + ", categoryName=" + categoryName + "]";
	}
	
}
