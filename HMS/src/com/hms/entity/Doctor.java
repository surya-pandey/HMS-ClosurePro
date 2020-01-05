package com.hms.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;


@Entity
public class Doctor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int doctorId;
private String doctorPassword;
private String firstName;
private String lastName;
private String department;
private String emergencyNumber;
private String primaryNumber;
//@ManyToMany(cascade=CascadeType.ALL)
//@JoinTable(name="demoSchedule", joinColumns={@JoinColumn(referencedColumnName="doctorId")}
//                                    , inverseJoinColumns={@JoinColumn(referencedColumnName="patientId")})  
//private Set<Patient> patients;

public int getDoctorId() {
	return doctorId;
}
public void setDoctorId(int doctorId) {
	this.doctorId = doctorId;
}
public String getDoctorPassword() {
	return doctorPassword;
}
public void setDoctorPassword(String doctorPassword) {
	this.doctorPassword = doctorPassword;
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
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getEmergencyNumber() {
	return emergencyNumber;
}
public void setEmergencyNumber(String emergencyNumber) {
	this.emergencyNumber = emergencyNumber;
}
public String getPrimaryNumber() {
	return primaryNumber;
}
public void setPrimaryNumber(String primaryNumber) {
	this.primaryNumber = primaryNumber;
}
@Override
public String toString() {
	return "Doctor [doctorId=" + doctorId + ", doctorPassword=" + doctorPassword + ", firstName=" + firstName
			+ ", lastName=" + lastName + ", department=" + department + ", emergencyNumber=" + emergencyNumber
			+ ", primaryNumber=" + primaryNumber + "]";
}



}
