package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hms.doctordao.DoctorDAO;
import com.hms.doctordao.DoctorDaoImpl;
import com.hms.entity.Doctor;
import com.hms.service.DoctorService;

@Controller
public class MainController {

//	@Autowired
//	private DoctorDAO doctorDao;
	
	@Autowired
	private DoctorService docService;
	
	
//	@RequestMapping(value="/adminMenu")
//	public String adminLogin(@RequestParam("uname") String uname,@RequestParam("password")String password,ModelMap map)
//	{
//		if(uname.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("admin"))
//			return "adminMenu";
//		
//		map.addAttribute("errorMessage","Invalid Credentials.Please Try Again");
//		return "adminLogin";
//		
//	}
	
	@RequestMapping(value="/")
	public ModelAndView mainLoginPage()
	{
		return new ModelAndView("allLogins");
	}
	
//	@RequestMapping(value="/AdminLogin.jsp")
//	public ModelAndView adminLogin() {
//		return new ModelAndView("adminLogin");
//	}
	
//	@RequestMapping(value="/adminLogin")
//	public ModelAndView adminLogin()
//	{	
//		
//		return new ModelAndView("adminLogin");
//	}
	
	@RequestMapping(value="/patientLogin")
	public String patientLogin() {
		return "patientLogin";
	}
	
	@RequestMapping(value="/doctorLogin")
	public ModelAndView doctorLogin() {
		return new ModelAndView("doctorLogin");
	}
}

