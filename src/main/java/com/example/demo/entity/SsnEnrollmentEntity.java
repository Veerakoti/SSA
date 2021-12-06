package com.example.demo.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Data
@Entity
@Table(name = "SSN_MASTER_DATA")
public class SsnEnrollmentEntity {
	@Id
	//@GeneratedValue
	@Column(name="SSN")
	@GenericGenerator(name ="order_id_gen",strategy = "com.example.demo.exceptions.SSNGenerator" )
	@GeneratedValue(generator ="order_id_gen")
	private String ssn;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="GENDER")
	private String gender;
	@Column(name="DOB")
	private Date dob;
	@Column(name="STATE_NAME")
	private String stateName;
	@Column(name="CREATED_DATE",updatable = false)
	@CreatedDate
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	@Column(name="UPDATED_DATE")
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updatedDate;

}
