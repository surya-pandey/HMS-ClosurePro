package com.hms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hms.entity.Doctor;
import com.hms.entity.Patient;
import com.hms.entity.Schedule;
import com.hms.patientdao.PatientDao;
import com.hms.patientservice.PatientService;

@Controller
//@SessionAttributes("patientId")
public class PatientController {
	
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private PatientService patientService;
	
	
	@RequestMapping(value="/patientMenuChoice")
	public String chooseMenuOption(@RequestParam("patientChoice") String patientChoice)
	{
		switch(patientChoice)
		{
		case "bookAppointment":
			return "selectDepartment";
			
		case "getDoctorEmergencyNumber":
			return "getEmergencyNumber";
		}
		return null;
	}
	
	@RequestMapping(value="/formForScheduleBooking")
	public ModelAndView scheduleBookingForm(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		return new ModelAndView("scheduleEntry","schedule",new Schedule());
	}

	@RequestMapping(value="/bookSchedule")
	public String bookSchedule(@ModelAttribute("schedule") Schedule schedule,HttpServletRequest request) 
	{
		
//		switch("slotChoice")
//		{
//		case "1":
//			schedule.setSlot1(true);
//			break;
//		case "2":
//			schedule.setSlot2(true);
//			break;	
//		case "3":
//			schedule.setSlot3(true);
//			break;
//		case "4":
//			schedule.setSlot4(true);
//			break;
//		}
		HttpSession session = request.getSession(false);
		schedule.setPatientId((int)session.getAttribute("patientId"));
//		schedule.setPatientId((int)map.get("patientId"));
		int id=patientDao.bookSchedule(schedule);
		System.out.println(id);
		return "generatedId";
	}
	
	@RequestMapping(value="/patientMenu")
	public String patientMenu(@RequestParam("id") String id,@RequestParam("password") String password,ModelMap map,HttpServletRequest request)
	{
		int id1=Integer.parseInt(id);
		boolean result = patientService.loginPatient(id1, password);

		
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("patientId",id1);
//			map.addAttribute("patientId",id1);
			return "patientMenuShow";
		}
		
		map.addAttribute("errorMessage","Invalid Credentials.Please Try Again");
		return "patientLogin"; 
	}
	
	@RequestMapping(value="/goForSignup")
	public ModelAndView patientSignup()
	{
		return new ModelAndView("patientSignUp","patient",new Patient());
	}
	
	@RequestMapping(value="/addNewPatient")
	public String addNewPatient(@ModelAttribute("patient") Patient patient,ModelMap map)
	{
		int patientId = patientService.signUp(patient);
		map.addAttribute("id",patientId);
		return "generatedId";
	}
	
	@RequestMapping(value="/getDoctorList")
	public String getDoctorList(@RequestParam("department") String department,ModelMap map,HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		
		List<Doctor> doctors = patientService.getDepttWiseDoctorList(department);
		
		map.addAttribute("doctorList",doctors);
		
		return "selectDepartment";
	}
	
	@RequestMapping(value="/getEmergencyNumber")
	public String getEmergencyNumber(@RequestParam("docId") String doctorId,ModelMap map,HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		String emergencyNumber = patientService.getDoctorEmergencyNumber(Integer.parseInt(doctorId));	
		map.addAttribute("emergencyNumber", emergencyNumber);
		return "getEmergencyNumber";
	}
	
	@RequestMapping(value="/patientLogout")
	public String doctorLogout(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		session.invalidate();
		request.getSession(false);
		return "patientLogin";
	}
	
	@RequestMapping(value="/backToPatientMenu")
	public String backToMenu()
	{
		return "patientMenuShow";
	}
	
//	@RequestMapping("/bookAppointment.jsp")
//	@ResponseBody
//	public String bookAppointment()
//	{
//		return "this is working";
//	}
	
}
