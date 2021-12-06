package com.example.demo.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.StateEntity;

public interface StateMasterRepo extends JpaRepository<StateEntity, Serializable> {
	@Query(value = "select stateName from StateEntity")
	public List<String> getAllStates();

}
