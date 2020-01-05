package com.hms.patientservice;

import java.util.List;

import com.hms.entity.Doctor;
import com.hms.entity.Patient;
import com.hms.entity.Schedule;

public interface PatientService {
		
		public boolean loginPatient(int id,String password);
		public int bookSchedule(Schedule schedule);
		public int signUp(Patient patient);
		public String getDoctorEmergencyNumber(int doctorId);
		public List<Doctor> getDepttWiseDoctorList(String department);
	
}
