package com.hms.doctordao;

import java.util.List;

import com.hms.entity.Doctor;
import com.hms.entity.Schedule;

public interface DoctorDAO {
	
	public Doctor doctorLogin(int id,String password);
	public int addDoctor(Doctor doctor);
	public List<Schedule> ownSchedule(int doctorId);
	public List<Schedule> otherDoctorSchedule(int doctorId);
	public boolean modifySchedule(int doctorId,Schedule newSchedule);
	public boolean changeEmergencyContact(int doctorId,String newEmergencyNum);
	
}
