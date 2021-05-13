package com.cg.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.cg.entities.Appointment;
import com.cg.exceptions.AppointmentNotFoundException;

public interface IAppointmentService {
	Appointment addAppointment(Appointment appointment) throws Exception;

	Appointment removeAppointment(int appointmentId) throws Exception;

	Set<Appointment> viewAppointments(String patientname) throws AppointmentNotFoundException;

	Appointment viewAppointment(int appointmentid) throws AppointmentNotFoundException;

	Appointment updateAppointment(Appointment appointment) throws AppointmentNotFoundException;

	List<Appointment> findAll();

//	List<Appointment> getApppointmentList(int centreId, String test, int status) throws Exception;

}