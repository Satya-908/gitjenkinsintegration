package com.userDoctors.service;

import java.util.List;

import com.userDoctors.entity.Doctor;
import com.userDoctors.entity.Patient;

public interface DoctorService {
	
	public Doctor showDoctorInformation(String name);
    
    public boolean saveDoctorInformation(Doctor doctor);
    
    public List<Doctor> getDoctors();
    
    public List<Patient> getPatientListOfDoctor(String name,Doctor doctor);
    
//    public boolean savePatientInformation(Patient patient); 
    public void savecount(Doctor ob);

}
