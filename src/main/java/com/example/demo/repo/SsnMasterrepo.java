package com.example.demo.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SsnEnrollmentEntity;

public interface SsnMasterrepo extends JpaRepository<SsnEnrollmentEntity, Serializable> {
	
	public SsnEnrollmentEntity findBySsnAndStateName(String ssn,String stateName);

}
