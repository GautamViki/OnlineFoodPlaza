package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.Login;

@Repository
public interface LoginDao extends JpaRepository<Login, Integer>{

}
