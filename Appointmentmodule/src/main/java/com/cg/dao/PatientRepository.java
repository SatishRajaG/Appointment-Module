package com.cg.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entities.Appointment;
import com.cg.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	public Set<Appointment> findByPatientname(String patientname);
}
