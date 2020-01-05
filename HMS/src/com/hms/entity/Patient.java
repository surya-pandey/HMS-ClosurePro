package com.hms.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	private String patientPassword;
	private String firstName;
	private String lastName;
	private String medicalHistory;
	private int phoneNumber;
//	@ManyToMany(mappedBy="patients")
//    private Set<Doctor> doctors;


	public Patient(String patientPassword, String firstName, String lastName, String medicalHistory,
			int phoneNumber) {
		super();
		this.patientPassword = patientPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.medicalHistory = medicalHistory;
		this.phoneNumber = phoneNumber;
	}

	public Patient() {
	}

	
	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientPassword() {
		return patientPassword;
	}

	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
