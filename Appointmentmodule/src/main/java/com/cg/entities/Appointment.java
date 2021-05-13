package com.cg.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "appointments1")
public class Appointment {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dtestid")
	private int dtestid;
	@Column(name = "appointmentdate", nullable = true)
	private LocalDate appointmentdate;
	@Column(name = "approvalstatus", nullable = true)
	private String approvalstatus;
	@OneToMany(mappedBy="appointment",cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<TestResult> testResult;
	@OneToOne
	@JoinColumn(name="id")
	private DiagnosticCenter diagnosticCenter;

	public Set<TestResult> getTestResult() {
		return testResult;
	}

	public Appointment(int dtestid, LocalDate appointmentdate, String approvalstatus, Set<TestResult> testResult,
			DiagnosticCenter diagnosticCenter, int appointmentid, Patient patient) {
		super();
		this.dtestid = dtestid;
		this.appointmentdate = appointmentdate;
		this.approvalstatus = approvalstatus;
		this.testResult = testResult;
		this.diagnosticCenter = diagnosticCenter;
		this.appointmentid = appointmentid;
		this.patient = patient;
	}

	public void setTestResult(Set<TestResult> testResult) {
		this.testResult = testResult;
	}

	public DiagnosticCenter getDiagnosticCenter() {
		return diagnosticCenter;
	}

	public void setDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		this.diagnosticCenter = diagnosticCenter;
	}

	@Column(name = "appointmentid")
	private int appointmentid;

	@ManyToOne
	@JoinColumn(name = "patientid")
	private Patient patient;

	public Appointment() {
		super();
	}

	public int getDtestid() {
		return dtestid;
	}

	public void setDtestid(int dtestid) {
		this.dtestid = dtestid;
	}

	public LocalDate getAppointmentdate() {
		return appointmentdate;
	}

	public void setAppointmentdate(LocalDate appointmentdate) {
		this.appointmentdate = appointmentdate;
	}

	public String getApprovalstatus() {
		return approvalstatus;
	}

	public void setApprovalstatus(String approvalstatus) {
		this.approvalstatus = approvalstatus;
	}

	public int getAppointmentid() {
		return appointmentid;
	}

	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Appointment [dtestid=" + dtestid + ", appointmentdate=" + appointmentdate + ", approvalstatus="
				+ approvalstatus + ", testResult=" + testResult + ", diagnosticCenter=" + diagnosticCenter
				+ ", appointmentid=" + appointmentid + ", patient=" + patient + "]";
	}

	
}
