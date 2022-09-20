package com.mindtree.doctor.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {
	@Id
	private Long doctorId;
	private String doctorName;
	private int age;
	private String gender;
	private String specialization;
	private int numberOfPatientattended;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(Long doctorId, String doctorName, int age, String gender, String specialization, int numberOfPatientattended) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.age = age;
		this.gender = gender;
		this.specialization = specialization;
		this.numberOfPatientattended=numberOfPatientattended;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public int getNumberOfPatientattended() {
		return numberOfPatientattended;
	}
	public void setNumberOfPatientattended(int numberOfPatientattended) {
		this.numberOfPatientattended = numberOfPatientattended;
	}
	
	
	
	

}
