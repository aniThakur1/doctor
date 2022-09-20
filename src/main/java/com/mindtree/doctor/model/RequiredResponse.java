package com.mindtree.doctor.model;

import java.util.List;

import com.mindtree.doctor.entity.Doctor;



public class RequiredResponse {
	
	private Doctor doctor;
	private List<Patient> patient;
	public RequiredResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequiredResponse(Doctor doctor, List<Patient> patient) {
		super();
		this.doctor = doctor;
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public List<Patient> getPatient() {
		return patient;
	}
	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}
	
	

}
