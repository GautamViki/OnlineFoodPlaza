package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.OrderDetails;

@Repository
public interface OrderDetailsDao extends JpaRepository<OrderDetails, String>{

}
