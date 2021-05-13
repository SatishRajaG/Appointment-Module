package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.dao.AppointmentRepository;
import com.cg.dao.PatientRepository;
import com.cg.entities.Appointment;
import com.cg.service.IAppointmentService;
import com.cg.service.IAppointmentServiceImpl;

@SpringBootTest
class AppointmentmoduleApplicationTests {
	@Autowired
	IAppointmentService appService;
	@MockBean
	AppointmentRepository appRepo;
	@MockBean
	PatientRepository patientRepo;

	@Test
	void contextLoads() {
		System.out.println("Context loaded successfully!!");
	}

	@Test
	public void viewAppointmentTest() {
		Appointment a = new Appointment();

		appRepo.findByAppointmentid(101);
		verify(appRepo, times(1)).findByAppointmentid(101);
	}

	@Test
	public void viewAppointmentsTest() {
		Appointment a = new Appointment();
		patientRepo.findByPatientname("Raja");
		verify(patientRepo, times(1)).findByPatientname("Raja");
	}
	@Test
	public void findAll() {
		List<Appointment> at;
		at=appRepo.findAll();
		verify(appRepo, times(1)).findAll();
		
		
	}
//	@Test
//	public void addAppointmentTest() {
//		String date = "2016-08-16";
//		LocalDate localDate = LocalDate.parse(date);
//
//		Appointment appointment = new Appointment(11,localDate,"Approved",101,(12,"9502585222",22,"Male","Ram"),null);
//		appRepo.save(appointment);
//		verify(appRepo, times(1)).save(appointment);
//	
//		//default, ISO_LOCAL_DATE
//
//	}

	@Test
	public void removeAppointmentTest() {
		appRepo.deleteById(133);
		verify(appRepo, times(1)).deleteById(133);
	}

}
