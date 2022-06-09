package com.userpatient.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.userpatient.entity.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient,Integer> {

}
