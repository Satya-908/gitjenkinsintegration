package com.userDoctors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.userDoctors.entity.Doctor;
import com.userDoctors.service.DoctorService;

@RestController

@CrossOrigin(origins = "http://localhost:4200")

public class DoctorController {
	
	@Autowired
    DoctorService doctorService; 
	
	@Autowired
	RestTemplate restTemplate; 
	
	
//	@CrossOrigin(origins = "http://localhost:4200", methods= {RequestMethod.POST})
	@PostMapping("/doctors/doctor")
    public boolean addUser(@RequestBody Doctor doctor) {
		doctorService.saveDoctorInformation(doctor);
		return true;
    }
	
	@GetMapping("doctors/doctor/{name}")
	public MappingJacksonValue getDoctorInformation(@PathVariable String name) {
		Doctor doctor = doctorService.showDoctorInformation(name);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "field","patient_count");

		FilterProvider filters = new SimpleFilterProvider().addFilter("DoctorFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(doctor);

		mapping.setFilters(filters);

		return mapping;
	}
	
	@GetMapping("doctors/doc/{name}")
	public Doctor getDoctorInfo(@PathVariable String name) {
		Doctor doctor = doctorService.showDoctorInformation(name); 
//		List patients = this.restTemplate.getForObject("http://localhost:9002/patient/doctor/"+doctor.getId(), List.class);
		
//		List patients = this.restTemplate.getForObject("http://localhost:9002/patient/doctor/"+doctor.getId(), List.class);
//		doctor.setPatients(patients);
		
		return doctor;
	}
	
	@GetMapping("doctors")
	public MappingJacksonValue getListOfDoctor() {
		List<Doctor> doctors = doctorService.getDoctors() ;
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");

		FilterProvider filters = new SimpleFilterProvider().addFilter("DoctorFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(doctors);

		mapping.setFilters(filters);

		return mapping;
	}
	
	
	///////////////////////// FOR PATIENT COUNT /////////////////////////////////////////////////////
	
	/*
	@GetMapping("doctors/p_count/{name}")
	public Integer getPatientCount( Doctor doctor) {
		
		Integer patient_count = doctor.getPatient_count();
		
		
		
		return patient_count+1;
		
	}
	*/
	
	@GetMapping("doctors/p_count/{name}")
	public MappingJacksonValue getPatientCount(@PathVariable String name) {
		Doctor doctor = doctorService.showDoctorInformation(name);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("patient_count");

		FilterProvider filters = new SimpleFilterProvider().addFilter("DoctorFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(doctor);

		mapping.setFilters(filters);
		
		doctor.setPatient_count(); 
		doctorService.savecount(doctor);
		
		System.out.println("Inside our func in doctor controller \n Patient count is: "+ doctor.getPatient_count());

		return mapping;
	}

}
