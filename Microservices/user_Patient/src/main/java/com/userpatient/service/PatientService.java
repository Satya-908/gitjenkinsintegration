package com.userpatient.service;

import java.util.List;

import com.userpatient.entity.Patient;

public interface PatientService {
//	public Doctor showDoctorInformation(String name);
    public Patient showPatientInformation(Integer Id);
   // public boolean saveDoctorInformation(Doctor doctor);
    public boolean savePatientInformation(Patient patient);
    //public List<Patient> getPatientListOfDoctor(String name,Doctor doctor); required
   // public List<Doctor> getDoctors();

}
