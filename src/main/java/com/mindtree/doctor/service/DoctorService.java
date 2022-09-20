package com.mindtree.doctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import com.mindtree.doctor.entity.Doctor;
import com.mindtree.doctor.model.Patient;
import com.mindtree.doctor.model.RequiredResponse;
import com.mindtree.doctor.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public Doctor createDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public List<Doctor> getAllDoctor() {
		return doctorRepository.findAll();
	}

	public RequiredResponse getAllDataByDoctorId(Long doctorId) {
		RequiredResponse requiredResponse  = new RequiredResponse();
	    Doctor doctor = doctorRepository.findByDoctorId(doctorId);
		requiredResponse.setDoctor(doctor);
		List<Patient> list = restTemplate.getForObject("http://localhost:1000/patient/patientId/"+doctorId, List.class);
		
		requiredResponse.setPatient(list);
		return requiredResponse;
	}

	public ResponseEntity<Doctor> getDoctorByName(String doctorName) {
		Doctor doctor= doctorRepository.findByDoctorName(doctorName);
		return ResponseEntity.ok(doctor);	}

}
