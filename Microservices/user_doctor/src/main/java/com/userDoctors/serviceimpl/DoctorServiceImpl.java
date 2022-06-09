package com.userDoctors.serviceimpl;

import java.awt.PageAttributes.MediaType;
import java.net.http.HttpHeaders;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userDoctors.entity.Doctor;
import com.userDoctors.entity.Patient;
import com.userDoctors.repository.DoctorRepository;

import  com.userDoctors.service.*;


@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
    DoctorRepository doctorRepository;  
	@Autowired 
	RestTemplate restTemplate;
	public Doctor showDoctorInformation(String name) {
		return doctorRepository.findByName(name);
	}

	public boolean saveDoctorInformation(Doctor doctor) {
		doctorRepository.save(doctor);
        return true;
	}

	public List<Doctor> getDoctors() {
		return (List<Doctor>) doctorRepository.findAll();
	}
	
	public List<Patient> getPatientListOfDoctor(String name, Doctor doctor) {
		 return doctor.getPatients();
	}
	
	/*
	public boolean savePatientInformation(Patient patient) { 
		
		Doctor doctor = doctorRepository.findByName(patient.getDoctor_name());
        doctor.addPatients(patient);
      // PatientRepository.save(patient);  
        restTemplate.patchForObject("http://localhost:/9002/patient",HttpMethod.POST,Patient.class);
        doctor.setPatient_count();
        return true;
	}
	*/
	public void savecount(Doctor ob) {
		doctorRepository.save(ob);
	}

}
