package com.hms.patientdao;


import java.util.List;

import com.hms.entity.Doctor;
import com.hms.entity.Patient;
import com.hms.entity.Schedule;

public interface PatientDao {
	
	public int bookSchedule(Schedule schedule);
	public Patient login(int id,String password);
	public int signup(Patient patient);
	public String getDoctorEmergencyNumber(int doctorId);
	public List<Doctor> getDepttWiseDoctorList(String department);
}
