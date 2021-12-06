package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "STATE_MASTER")
@Data
public class StateEntity {

	@Id
	@GeneratedValue
	@Column(name = "STATE_ID")
	private int stateId;
	@Column(name = "STATE_NAME")
	private String stateName;
}
