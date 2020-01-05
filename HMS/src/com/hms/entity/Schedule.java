package com.hms.entity;

//package com.project.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Schedule {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int scheduleId;

//@OneToOne
//@JoinColumn(name="doctor_id",nullable=true)
//private Doctor doctor;

private int doctorId;
private int patientId;

//@OneToOne
//@JoinColumn(name="patienti_d",nullable=true)
//private Patient patient;

private String appDate;

@Column(nullable=true)
private String slot;

public Schedule()
{
	}

public int getScheduleId() {
	return scheduleId;
}



public void setScheduleId(int scheduleId) {
	this.scheduleId = scheduleId;
}



public int getDoctorId() {
	return doctorId;
}



public void setDoctorId(int doctorId) {
	this.doctorId = doctorId;
}



public int getPatientId() {
	return patientId;
}



public void setPatientId(int patientId) {
	this.patientId = patientId;
}



public String getAppDate() {
	return appDate;
}



public void setAppDate(String appDate) {
	this.appDate = appDate;
}



public String getSlot() {
	return slot;
}



public void setSlot(String slot) {
	this.slot = slot;
}



public Schedule(int scheduleId, int doctorId, int patientId, String appDate, String slot) {
	super();
	this.scheduleId = scheduleId;
	this.doctorId = doctorId;
	this.patientId = patientId;
	this.appDate = appDate;
	this.slot = slot;
}

@Override
public String toString() {
	return "Schedule [scheduleId=" + scheduleId + ", doctorId=" + doctorId + ", patientId=" + patientId + ", appDate="
			+ appDate + ", slot=" + slot + "]";
}



}
