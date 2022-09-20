package com.mindtree.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.doctor.entity.Doctor;
import com.mindtree.doctor.model.RequiredResponse;
import com.mindtree.doctor.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@CrossOrigin("http://localhost:4200/")
	@PostMapping("/get")
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return doctorService.createDoctor(doctor);
	}
	
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/get")
	public List<Doctor> getAllDoctor(){
		return doctorService.getAllDoctor();
	}
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/patientId/{doctorId}")
	public RequiredResponse getAllDataByDoctorId(@PathVariable Long doctorId) {
		return doctorService.getAllDataByDoctorId(doctorId);
	}
	
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/get/{doctorName}")
	public ResponseEntity<Doctor> getDoctorByName(@PathVariable String doctorName) {
		return doctorService.getDoctorByName(doctorName);
	}
}
