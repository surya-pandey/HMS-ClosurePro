package com.hms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.doctordao.DoctorDAO;
import com.hms.entity.Doctor;
import com.hms.entity.Schedule;


@Service
public class DocServiceImpl implements DoctorService{

	@Autowired
	private DoctorDAO doctorDao;
	@Override
	public int signup(Doctor doctor) {
		int id = doctorDao.addDoctor(doctor);
		return id;
	}
	
	@Override
	public boolean login(int id, String password) {
		// TODO Auto-generated method stub
		
		Doctor doctor=doctorDao.doctorLogin(id, password);
		if((doctor!=null)&&((doctor.getDoctorId()==id)&&(doctor.getDoctorPassword().equals(password))))
			return true;
		return false; 
	}

	@Override
	public boolean changeSchedule(int doctorId,Schedule newSchedule) {
		// TODO Auto-generated method stub
		
		boolean result = doctorDao.modifySchedule(doctorId, newSchedule);
		
		return result;
	}

	@Override
	public List<Schedule> ownSchedule(int doctorId) {
		// TODO Auto-generated method stub
		return doctorDao.ownSchedule(doctorId);
	}

	@Override
	public boolean changeEmergencyNumber(int doctorId, String newEmergencyNumber) {
		// TODO Auto-generated method stub
		
		boolean result=doctorDao.changeEmergencyContact(doctorId, newEmergencyNumber);
		
		return result;
	}

}
