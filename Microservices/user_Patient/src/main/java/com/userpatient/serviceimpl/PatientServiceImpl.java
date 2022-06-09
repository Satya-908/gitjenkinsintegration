package com.userpatient.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.userpatient.entity.Doctor;
import com.userpatient.entity.Patient;
import com.userpatient.repository.PatientRepository;
import com.userpatient.service.PatientService;
@Repository
@Transactional

public class PatientServiceImpl implements PatientService {
@Autowired
PatientRepository patientRepository; 
@Autowired 
RestTemplate restTemplate;
public Patient showPatientInformation(Integer id) {
    return patientRepository.findById(id).get();
} 


public boolean savePatientInformation(Patient patient) {

   // Doctor doctor = doctorRepository.findByName(patient.getDoctor_name()); 
	
	//Doctor doctor = this.restTemplate.getForObject("http://doctor-service/doctors/doctor/"+patient.getDoctor_name(), Doctor.class);
	Doctor doctor = this.restTemplate.getForObject("http://doctor-service/doctors/doctor/"+patient.getDoctor_name(), Doctor.class);
	//	Doctor doctor = this.restTemplate.getForObject("http://localhost:9001/doctors/doctor/"+patient.getDoctor_name(), Doctor.class);
	
//	Doctor doctor = restTemplate.getForObject("http:localhost:9002/patient.getDoctor_name()", Doctor.class);
    doctor.addPatients(patient);
    patientRepository.save(patient);
    
    
    ///////////////////////// FOR PATIENT COUNT /////////////////////////////////////////////////////
    
//    Integer patient_count = this.restTemplate.getForObject("http://doctor-service/doctors/p_count/"+patient.getDoctor_name(),Integer.class);
    
    Doctor patient_count = this.restTemplate.getForObject("http://doctor-service/doctors/p_count/"+patient.getDoctor_name(), Doctor.class);
  //  Patient patient_count = this.restTemplate.getForObject("http://doctor-service/doctors/p_count/"+patient.getDoctor_name(), Patient.class);
    System.out.println("Inside patientServiceImpl in user_Patient \n Patient count is: "+ patient_count.getPatient_count());
    
   
    
   // doctor.setPatient_count(patient_count);
    
   //patient_count.setPatient_count();
    return true;
}


public List<Patient> getPatientListOfDoctor(String name, Doctor doctor) {
    return doctor.getPatients();
}



}
