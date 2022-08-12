package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Bill;

public interface BillDao extends JpaRepository<Bill, String> {

}
