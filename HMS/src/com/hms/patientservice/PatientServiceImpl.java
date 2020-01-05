package com.hms.patientservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.entity.Doctor;
import com.hms.entity.Patient;
import com.hms.entity.Schedule;
import com.hms.patientdao.PatientDao;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patientDao;
	
	@Override
	public boolean loginPatient(int id, String password) {
		
		Patient patient = (Patient)patientDao.login(id, password);
		if((patient!=null)&&((id==patient.getPatientId())&&password.equals(patient.getPatientPassword())))
			return true;
		return false;
	}

	@Override
	public int bookSchedule(Schedule schedule) {
		int bookingId = patientDao.bookSchedule(schedule);
		return bookingId;
	}

	@Override
	public int signUp(Patient patient) {
		int patientId = patientDao.signup(patient);
		return patientId;
	}

	@Override
	public String getDoctorEmergencyNumber(int doctorId) {
		
		return patientDao.getDoctorEmergencyNumber(doctorId); 
	}

	@Override
	public List<Doctor> getDepttWiseDoctorList(String department) {
		// TODO Auto-generated method stub
		
		List<Doctor> doctors = patientDao.getDepttWiseDoctorList(department);
		
		return doctors;
	}

}
