package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Owner;

public interface OwnerDao extends JpaRepository<Owner, Integer>{

}
