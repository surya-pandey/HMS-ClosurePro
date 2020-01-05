package com.hms.doctordao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hms.entity.Doctor;
import com.hms.entity.Schedule;

@Repository
public class DoctorDaoImpl implements DoctorDAO {

	@Autowired
	private HibernateTemplate hiberTemplate;

	private Doctor doctor;
	
	
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Autowired
	private SessionFactory sf;
//	
//	public void setHiberTemplate(HibernateTemplate hiberTemplate) {
//		this.hiberTemplate = hiberTemplate;
//}

	@Override
	public int addDoctor(Doctor doctor) {
		
//		Session s= sf.openSession();
//		Transaction tx = s.beginTransaction();
//		s.save(doctor);
//		tx.commit();
//		s.close();
		int id = (int)hiberTemplate.save(doctor);
		System.out.println(id);
		return id;
	}

	@Override
	public List<Schedule> ownSchedule(int doctorId) {
		// TODO Auto-generated method stub
//		List <Schedule> sch = (List<Schedule>) hiberTemplate.getSessionFactory().getCurrentSession().createQuery("from Schedule where doctorId="+doctorId).getResultList();
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		
		Query query = session.createQuery("from Schedule where doctorId=:doctorId");
		query.setParameter("doctorId", doctorId);
		List<Schedule> sch = (List<Schedule>)query.getResultList();
		
		tx.commit();
		session.close();
		if(sch!=null)
			return sch;
			
		return null;
	}

	@Override
	public List<Schedule> otherDoctorSchedule(int doctorId) {
		// TODO Auto-generated method stub
		
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		
		Query query = session.createQuery("from Schedule where doctorId=:doctorId");
		query.setParameter("doctorId", doctorId);
		List<Schedule> sch = (List<Schedule>)query.getResultList();
		
		tx.commit();
		session.close();
		if(sch!=null)
			return sch;
			
		return null;
		
//		List <Schedule> sch = (List<Schedule>) hiberTemplate.getSessionFactory().getCurrentSession().createQuery("from Schedule where doctorId="+doctorId).getResultList();
//		return sch;
		
//		Schedule sch = (Schedule)hiberTemplate.get(Schedule.class, doctorId);
//		if(sch!=null) {
//		return sch;
//		}
//		return null;
	}

	@Override
	public boolean modifySchedule(int doctorId,Schedule newSchedule) {
		
//		Session session = sf.openSession();
//		Transaction tx=session.beginTransaction();
//		
//		Query query = session.createQuery("from Schedule where doctorId=:doctorId and appDate=:appDate");
//		query.setParameter("doctorId", doctorId);
//		query.setParameter("appDate",newSchedule.getAppDate());
//		List<Schedule> sch = (List<Schedule>)query.getResultList();
//		
//		if(sch!=null)
//		{
//			for(Schedule sch1:sch) {
//				sch1.setSlot(newSchedule.getSlot());
//				session.saveOrUpdate(sch1);
//			}
//		
//		
//		tx.commit();
//		session.close();
//		return true;
//		}	
//		
//		tx.commit();
//		session.close();
//		return false;
		
		Schedule oldSchedule=hiberTemplate.get(Schedule.class,newSchedule.getScheduleId());
		
		if(oldSchedule!=null) {
		oldSchedule.setSlot(newSchedule.getSlot());
		hiberTemplate.saveOrUpdate(oldSchedule);
		return true;
		}
		return false;
		
	}

	@Override
	public boolean changeEmergencyContact(int doctorId,String newEmergencyNum) {
		// TODO Auto-generated method stub
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Doctor where doctorId=:doctorId");
		query.setParameter("doctorId", doctorId);
		Doctor doc = (Doctor)query.getSingleResult();
		if(doc!=null) {
		doc.setEmergencyNumber(newEmergencyNum);	
		session.saveOrUpdate(doc);
		tx.commit();
		session.close();
		return true;
		}
		tx.commit();
		session.close();
		return false;
	}

	@Override
	public Doctor doctorLogin(int id,String password) {
//		Doctor doc = (Doctor)hiberTemplate.findByNamedParam("from Doctor where doctorId=:id and doctorPassword=:password",new String[] {"id","password"}, new Object[] {"id","Password"});
		Doctor doc=hiberTemplate.get(Doctor.class, id);
		return doc;
}
}