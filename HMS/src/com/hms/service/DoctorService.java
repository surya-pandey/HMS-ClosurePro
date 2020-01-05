package com.hms.service;

import java.util.List;
import java.util.Map;

import com.hms.entity.Doctor;
import com.hms.entity.Schedule;

public interface DoctorService {
	
	public int signup(Doctor doctor);
	public boolean login(int id,String password);
	public boolean changeSchedule(int doctorId,Schedule newSchedule);
	public List<Schedule> ownSchedule(int doctorId);
	public boolean changeEmergencyNumber(int doctorId, String newEmergencyNumber);
//	public List<Schedule> otherSchedule(int doctorId);

}
