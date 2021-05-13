package com.cg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Appointment;
import com.cg.exceptions.AppointmentNotFoundException;
import com.cg.service.IAppointmentService;

@RestController
@RequestMapping("/application")
public class AppointmentControl {
	@Autowired
	IAppointmentService appointmentservice;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/user")
	public List<Appointment> findUser() {
		logger.info("called find user method()");
		return appointmentservice.findAll();

	}

	@GetMapping("/getById/{appointmentid}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable("appointmentid") int appointmentId)
			throws AppointmentNotFoundException {
		logger.info("called getAppointmetById method()");
		Appointment appointment = null;
		appointment = appointmentservice.viewAppointment(appointmentId);
		if (appointment == null) {
			logger.error("No appointment found with this id" + appointmentId);
			throw new AppointmentNotFoundException("No appointment found with this id:" + appointmentId);
		}
		return new ResponseEntity<>(appointment, HttpStatus.OK);
	}

	@DeleteMapping("/remove/{appointmentid}")
	public ResponseEntity<Appointment> removeAppointmentById(@PathVariable("appointmentid") int appointmentid)
			throws Exception {
		logger.info("called Delete removeAppointmen method()");
		Appointment appointment = appointmentservice.removeAppointment(appointmentid);
		if (appointment == null) {
			logger.error("remove appointment is not found with this appointmentIdid");
			throw new AppointmentNotFoundException("remove appointment id is not found" + appointmentid);
		}

		return new ResponseEntity<>(appointment, HttpStatus.OK);

	}

	@GetMapping("/bypatient/{patientname}")
	public ResponseEntity<Set<Appointment>> getAppointmentByPatientName(@PathVariable("patientname") String patientname)
			throws AppointmentNotFoundException {
		logger.info("called Get AppointmentBYPatient method()");
		Set<Appointment> appointment = appointmentservice.viewAppointments(patientname);
		if (appointment.isEmpty()) {
			logger.error("No appointment is assigned to this patient name:" + patientname);
			throw new AppointmentNotFoundException("No Appointment find with patient name" + patientname);
		}

		return new ResponseEntity<>(appointment, HttpStatus.OK);

	}

	@PostMapping("/addappointment")
	public ResponseEntity<Appointment> addAppointment(@Validated @RequestBody Appointment appointment)
			throws Exception {
		logger.info("called Post addAppointment method()");
		Appointment app = appointmentservice.addAppointment(appointment);

		return new ResponseEntity<>(app, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Appointment> updateAppointment(@Validated @RequestBody Appointment appointment)
			throws AppointmentNotFoundException {
		logger.info("called Put updateAppointment  method()");
		Appointment appo = appointmentservice.updateAppointment(appointment);

		return new ResponseEntity<>(appo, HttpStatus.OK);

	}
}