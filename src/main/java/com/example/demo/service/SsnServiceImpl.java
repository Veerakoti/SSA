package com.example.demo.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SsnEnrollmentEntity;
import com.example.demo.exceptions.ResourceNotCreatedException;
import com.example.demo.model.SsnAuthenticationFormModel;
import com.example.demo.repo.SsnMasterrepo;
import com.example.demo.repo.StateMasterRepo;
@Service
public class SsnServiceImpl implements SsnService {
	@Autowired
	private SsnMasterrepo ssnrepo;
	@Autowired
	private StateMasterRepo stateRepo;

	@Override
	public List<String> getAllStateNames() {
		// TODO Auto-generated method stub
		return stateRepo.getAllStates();
	}

	@Override
	public String ssnEnrollment(SsnAuthenticationFormModel formModel) {
		SsnEnrollmentEntity enrollmentEntity=new SsnEnrollmentEntity();
		BeanUtils.copyProperties(formModel, enrollmentEntity);
		SsnEnrollmentEntity saveEnroll = ssnrepo.save(enrollmentEntity);
		if (saveEnroll!=null && saveEnroll.getSsn()!=null) {
			return " your enrollment completed successfully :: "+saveEnroll.getSsn();
			
		}
		else {
			throw new ResourceNotCreatedException();
		}
		//return null;
	}

	@Override
	public String checkEnrollment(String ssn, String stateName) {
		SsnEnrollmentEntity findBySsnAndStateName = ssnrepo.findBySsnAndStateName(ssn, stateName);
		if(findBySsnAndStateName!=null && findBySsnAndStateName.getSsn()!=null) {
			return "VALID-SSN";
		}/*else {
			throw new InvalidSSnException();
		}*/
		return "IN-VALID-SSN";
	}

}
