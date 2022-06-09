package com.userDoctors.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Doctor {
	@Id
    @GeneratedValue
    private Integer id;
	
   // @Column(unique = true)
	@Column()
    private String name;
    private Integer age;
    private String gender;
    private String field;
    private Integer patient_count=0;
//    private Integer patient_count=2;

    @OneToMany
    private List<Patient> patients;

    public List<Patient> getPatients() {
        return patients;
    }
    
    
    
    public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public void addPatients(Patient patient) {
        patients.add(patient);
    }

    public Doctor() {
    }

    public Doctor(String name, Integer age, String gender, String field) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.field = field;
    }

    @Override
    public String toString() {
        return "Doctor [age=" + age + ", field=" + field + ", gender=" + gender + ", id=" + id + ", name=" + name + "]";
    }

    public Integer getPatient_count() {
        return patient_count;
    }

    public void setPatient_count() {
        
    	System.out.println("Before In user_doctor setpatient_count\n patient count set to: "+ this.patient_count);
        this.patient_count +=1;
        System.out.println("After In user_doctor setpatient_count \n patient count set to: "+ this.patient_count);
    }

    public Integer getId() {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

}
