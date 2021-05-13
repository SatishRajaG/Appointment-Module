package com.cg.dao;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entities.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

	public Appointment findByAppointmentid(int appointmentid);

	
	
	
}