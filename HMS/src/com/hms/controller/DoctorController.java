package com.hms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hms.entity.Doctor;
import com.hms.entity.Schedule;
import com.hms.service.DoctorService;

@Controller
//@SessionAttributes("id")
public class DoctorController {
	
//	private HttpSession session;
	
	@Autowired
	private DoctorService docService;
	
	@RequestMapping(value="/addDoctor")
	public ModelAndView AddDoctorPage()
	{
		return new ModelAndView("doctorAdd","doctor",new Doctor());
	}
	
	
	@RequestMapping(value="/docLogin")
	public String doctorLogin(@RequestParam("id") String id, @RequestParam("password") String password ,ModelMap map,HttpServletRequest request)
	{
		
		int id1=Integer.parseInt(id);
		boolean value=docService.login(id1, password);
		if(value) {
//			map.addAttribute("id",id);
			HttpSession session = request.getSession();
			session.setAttribute("doctorId", id1);
			return "doctorMenu";
		}
		
		map.addAttribute("errorMessage","Invalid Credentials.Please Try Again");
		return "doctorLogin";
	}
	
	@RequestMapping(value="/doctorChoice")
	public ModelAndView doctorChoice(@RequestParam("doctorChoice") String doctorChoice,ModelMap map,HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		switch (doctorChoice) 
		{
		case "ownSchedule":
			List<Schedule> sch = docService.ownSchedule((int)session.getAttribute("doctorId"));
			map.addAttribute("myMap", sch);
			return new ModelAndView("scheduleShow");
			
		case "otherSchedule":
			return new ModelAndView("otherScheduleShow");
			
		case "updateSchedule":
			return new ModelAndView("updateSchedule","updatedSchedule",new Schedule());
		
		case "changeEmergencyNumber":
			return new ModelAndView("changeEmergency");
		}
		return new ModelAndView("doctorMenu");
	}
	
	@RequestMapping("/addNewDoctor")
	public String AddDoctor(@ModelAttribute("doctor") Doctor doctor,ModelMap map)
	{
		int doctorId=docService.signup(doctor);
		map.addAttribute("id",doctorId);
		return "generatedId";
		}
	  
//	@RequestMapping("/mySchedule.jsp")
//	public String myScheduleShow(ModelMap map)
//	{
//		List<Schedule> sch = docService.ownSchedule(Integer.parseInt((String)map.get("id")));
//		map.addAttribute("myMap", sch);
//		return "mySchedule";
//	}

	@RequestMapping(value="/otherSchedule")
	public ModelAndView otherSchedule(@RequestParam("id") int id,ModelMap map,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		List<Schedule> sch = docService.ownSchedule(id);
		map.addAttribute("myMap", sch);
		return new ModelAndView("scheduleShow");
	}
	
	@RequestMapping(value="/updateSchedule")
	public String updateSchedule(@ModelAttribute("updatedSchedule") Schedule updatedSchedule,HttpServletRequest request,ModelMap map)
	{
		HttpSession session = request.getSession(false);
		boolean result = docService.changeSchedule((int)session.getAttribute("doctorId"),updatedSchedule);
		map.addAttribute("result",result);
		return "updateResult";
	}
	
	@RequestMapping(value="/updateEmergencyNumber")
	public String updateEmergencyNumber(@RequestParam("newEmergencyNumber") String newEmergencyNumber,ModelMap map,HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		boolean result = docService.changeEmergencyNumber((int)session.getAttribute("doctorId"), newEmergencyNumber);
		map.addAttribute("result",result);
		return "updateResult";
	}
	
	@RequestMapping(value="/doctorLogout")
	public String doctorLogout(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		session.invalidate();
		session = request.getSession(false);
		return "doctorLogin";
	}
	
	@RequestMapping(value="/backToDoctorMenu")
	public String backToMenu()
	{
		return "doctorMenu";
	}
	
}
