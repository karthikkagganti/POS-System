package com.pos.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.pos.demo.entity.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
