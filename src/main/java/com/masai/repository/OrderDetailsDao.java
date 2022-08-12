package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.OrderDetails;

public interface OrderDetailsDao extends JpaRepository<OrderDetails, String>{

}
