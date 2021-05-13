package com.cg.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "TestResults1")
public class TestResult implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "testReading")
	private double testReading;
	@Column(name = "condition")
	private String condition;
	@ManyToOne
	@JoinColumn(name = "appointmentid")
	private Appointment appointment;

	public TestResult() {
		super();
	}

	public TestResult(int id, double testReading, String condition, Appointment appointment) {
		super();
		this.id = id;
		this.testReading = testReading;
		this.condition = condition;
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "TestResult [id=" + id + ", testReading=" + testReading + ", condition=" + condition + ", appointment="
				+ appointment + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTestReading() {
		return testReading;
	}

	public void setTestReading(double testReading) {
		this.testReading = testReading;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}