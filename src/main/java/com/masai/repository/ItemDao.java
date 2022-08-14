package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.Item;
@Repository
public interface ItemDao extends JpaRepository<Item, Integer>{

}
