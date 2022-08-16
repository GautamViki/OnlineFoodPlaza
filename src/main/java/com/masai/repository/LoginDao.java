package com.masai.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.Login;


public interface LoginDao extends JpaRepository<Login, Integer>{

		
}
