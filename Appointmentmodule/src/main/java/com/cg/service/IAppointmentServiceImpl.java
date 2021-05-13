package com.cg.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.AppointmentRepository;
import com.cg.dao.PatientRepository;
import com.cg.entities.Appointment;
import com.cg.exceptions.AppointmentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class IAppointmentServiceImpl implements IAppointmentService {
	@Autowired
	AppointmentRepository arepo;
	@Autowired
	PatientRepository prepo;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Appointment removeAppointment(int appointmentid) throws Exception {
		logger.info("called remove Appointment method()");
		Appointment appointment = arepo.findByAppointmentid(appointmentid);
		arepo.deleteById(appointmentid);
		return appointment;

	}

	@Override
	public Appointment viewAppointment(int appointmentid) throws AppointmentNotFoundException {
		logger.info("called view Appointment method()");

		Appointment appointment = arepo.findByAppointmentid(appointmentid);
		return appointment;
	}

	@Override
	@Transactional
	public Appointment updateAppointment(Appointment appointment) throws AppointmentNotFoundException {
		Optional<Appointment> optionaloppointment = arepo.findById(appointment.getAppointmentid());

		logger.info("called updateAppointment method()" + appointment);

		if (!optionaloppointment.isPresent()) {
			Appointment dbAppointment = optionaloppointment.get();

			dbAppointment.setDiagnosticCenter(appointment.getDiagnosticCenter());
			dbAppointment.setTestResult(appointment.getTestResult());
			dbAppointment.setDtestid(appointment.getDtestid());
			dbAppointment.setAppointmentdate(appointment.getAppointmentdate());
			dbAppointment.setApprovalstatus(appointment.getApprovalstatus());
			dbAppointment.setAppointmentid(appointment.getAppointmentid());
			dbAppointment.setPatient(appointment.getPatient());
			arepo.save(appointment);
		}

		return appointment;
	}

	@Override
	public Appointment addAppointment(Appointment appointment) throws AppointmentNotFoundException {
		logger.info("called addAppointment method()" + appointment);
		Optional<Appointment> oppointment = arepo.findById(appointment.getAppointmentid());
		if (oppointment.isPresent()) {
			Appointment dbAppointment = oppointment.get();

			dbAppointment.setDiagnosticCenter(appointment.getDiagnosticCenter());
			dbAppointment.setTestResult(appointment.getTestResult());
			dbAppointment.setDtestid(appointment.getDtestid());
			dbAppointment.setAppointmentdate(appointment.getAppointmentdate());
			dbAppointment.setApprovalstatus(appointment.getApprovalstatus());
			dbAppointment.setAppointmentid(appointment.getAppointmentid());
			dbAppointment.setPatient(appointment.getPatient());
			arepo.save(appointment);
		}
		return appointment;

	}

	@Override
	public List<Appointment> findAll() {
		return arepo.findAll();
	}

	@Override
	public Set<Appointment> viewAppointments(String patientname) throws AppointmentNotFoundException {
		logger.info("called viewAppointment method()" + patientname);

		Set<Appointment> appointment = prepo.findByPatientname(patientname);
		return appointment;
	}

}