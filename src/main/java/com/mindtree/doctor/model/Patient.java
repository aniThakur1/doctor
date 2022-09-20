package com.mindtree.doctor.model;

public class Patient {
	private Long patientId;
	private String patientName;
	private String visitedDoctor;
	private String dateOfVisit;
	private Long doctorId;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(Long patientId, String patientName, String visitedDoctor, String dateOfVisit, Long doctorId) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.visitedDoctor = visitedDoctor;
		this.dateOfVisit = dateOfVisit;
		this.doctorId = doctorId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getVisitedDoctor() {
		return visitedDoctor;
	}
	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}
	public String getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	
	

}
