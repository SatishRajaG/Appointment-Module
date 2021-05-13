package com.cg.entities;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

public enum AppointmentStatus {
	approved("approved"), cancelled("cancelled");

	@OneToOne(mappedBy = "astatus", cascade = CascadeType.ALL)
	private Appointment appointments;

	AppointmentStatus(String status) {
		this.setStatus(status);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String status;
}
