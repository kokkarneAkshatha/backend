package com.example.demo.sevice;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PatientRegistration;
import com.example.demo.repository.PatientRegistrationRepository;

@Service
public class PatientRegistrationServiceImpl implements PatientRegistrationService {
	
	@Autowired
	PatientRegistrationRepository patientRegistrationrepository;

	@Override
	@Transactional
	public List<PatientRegistration> getPatientRegistrations() {
		// TODO Auto-generated method stub
		return patientRegistrationrepository.findAll();
	}

	@Override
	@Transactional
	public PatientRegistration savePatientRegistration(PatientRegistration thePatientRegistration) {
		// TODO Auto-generated method stub
		return patientRegistrationrepository.save(thePatientRegistration);
		
	}

	@Override
	@Transactional
	public Optional<PatientRegistration> getPatientRegistrationById(int theId) {
		// TODO Auto-generated method stub
		
		return patientRegistrationrepository.findById(theId);
	}

	@Override
	@Transactional
	public void deletePatientRegistrationById(int theId) {
		// TODO Auto-generated method stub
		Optional<PatientRegistration> patient = getPatientRegistrationById(theId);
        if(patient != null){
        	patientRegistrationrepository.deleteById(theId);
        }
        
		
	}

	@Override
	public PatientRegistration updatepatientregistration(PatientRegistration patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientRegistration getPatientLogindetails(String email) {
		// TODO Auto-generated method stub
		return patientRegistrationrepository.findByEmail(email);
	
	}
	@Override
	public boolean checkPass(String email, String password) {
		PatientRegistration patientregistration =	getPatientLogindetails( email);
		if(patientregistration!=null) {
			if (BCrypt.checkpw(password, patientregistration.getPassword()))
				return true;
			else
				return false;
		}
		else {
			return false;
		}
		
		
		}
		

}