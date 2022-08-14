package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masai.entity.Foodcart;

@Repository
public interface FoodcartDao extends JpaRepository<Foodcart, Integer> {
	
	
}
