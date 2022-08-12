package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Restaurant;

public interface RestaurantDao extends JpaRepository<Restaurant, String>{

}
