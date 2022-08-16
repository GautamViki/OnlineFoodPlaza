package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.Bill;

@Repository
public interface BillDao extends JpaRepository<Bill, Integer>{

}
