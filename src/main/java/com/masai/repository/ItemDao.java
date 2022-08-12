package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Item;

public interface ItemDao extends JpaRepository<Item, String>{

}
