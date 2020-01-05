package com.hms.patientdao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hms.entity.Doctor;
import com.hms.entity.Patient;
import com.hms.entity.Schedule;


@Repository
public class PatientDaoImpl implements PatientDao{

	@Autowired
	private HibernateTemplate hiberTemplate;
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public int bookSchedule(Schedule schedule) {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Doctor where doctorId=:doctorId");
		query.setParameter("doctorId", schedule.getDoctorId());
		Doctor doctor= (Doctor) query.getSingleResult();
		
		if(doctor!=null) {
		int schId = (int)hiberTemplate.save(schedule);
		tx.commit();
		session.close();
		return schId;
		}
		tx.commit();
		session.close();
		return 0;
	}

	@Override
	public Patient login(int id, String password) {
		
		Patient patient=(Patient)hiberTemplate.get(Patient.class, id);
		
		return patient;
	}

	@Override
	public int signup(Patient patient) {
		int patientId = (int)hiberTemplate.save(patient);
		return patientId;
	}

	@Override
	public String getDoctorEmergencyNumber(int doctorId) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Doctor where doctorId=:doctorId");
		query.setParameter("doctorId",doctorId);
		Doctor doc = (Doctor)query.getSingleResult();
		
		
		tx.commit();
		session.close();
		
		return doc.getEmergencyNumber();
		
		}

	@Override
	public List<Doctor> getDepttWiseDoctorList(String department) {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Doctor where department=:department");
		query.setParameter("department",department);
		List<Doctor> doctors= (List<Doctor>) query.getResultList();
		return doctors;
	}
	
	
}
