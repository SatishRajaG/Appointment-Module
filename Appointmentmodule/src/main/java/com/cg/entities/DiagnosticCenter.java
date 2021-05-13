package com.cg.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "DiagnosticCenter1")
public class DiagnosticCenter implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	private String name;
	private String contactNo;
	private String address;
	private String contactEmail;
	private String servicesOffered;

	// private Set<DiagnosticTest> tests = new HashSet<>();
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public DiagnosticCenter() {
		super();
	}

	public DiagnosticCenter(int id, String name, String contactNo, String address, String contactEmail,
			String servicesOffered, Appointment apointment) {
		super();
		this.id = id;
		this.name = name;
		this.contactNo = contactNo;
		this.address = address;
		this.contactEmail = contactEmail;
		this.servicesOffered = servicesOffered;
	}

	@Override
	public String toString() {
		return "DiagnosticCenter [id=" + id + ", name=" + name + ", contactNo=" + contactNo + ", address=" + address
				+ ", contactEmail=" + contactEmail + ", servicesOffered=" + servicesOffered + "]";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getServicesOffered() {
		return servicesOffered;
	}

	public void setServicesOffered(String servicesOffered) {
		this.servicesOffered = servicesOffered;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
