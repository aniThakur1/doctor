package com.mindtree.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.doctor.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

	Doctor findByDoctorId(Long doctorId);

	

	Doctor findByDoctorName(String doctorName);

	

    

}
