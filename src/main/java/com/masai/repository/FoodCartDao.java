package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.FoodCart;

public interface FoodCartDao extends JpaRepository<FoodCart, String>{

}
