package com.footballproject.controller;

import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.footballproject.model.Department;
import com.footballproject.model.Staff;
import com.footballproject.services.DepartmentService;
import com.footballproject.services.StaffService;

@Controller
public class StaffController {

	@Autowired
	DepartmentService departmentService;

	@Autowired
	StaffService staffService;

	@RequestMapping(value = "staffPage", method = RequestMethod.GET)
	public ModelAndView staffPage(HttpSession httpSession, @ModelAttribute("command") Staff staff,
			BindingResult bindingResult) {
		if ((httpSession.getAttribute("user") != null) && ((Integer) httpSession.getAttribute("post") == 1)) {
			ModelAndView model = new ModelAndView("staffPage");
			model.addObject("departments", departmentService.getDepartment());
			model.addObject("staffList", staffService.getStaff());
			
			return model;
		}
		return new ModelAndView("redirect:/");

	}
	
	@RequestMapping(value = "registerStaff", method = RequestMethod.POST)
	public String registerStaff(HttpSession httpSession,@ModelAttribute Staff staff, BindingResult bindingResult) {
		// set id increment value to 0
				if (staff.userId == null || staff.userId.isEmpty()) {
					int incrementId = 0;
					// when these is already available member with given member id set the increment
					// the Id
					while (staffService.getStaff("SF-" + (staffService.getStaffCount() + incrementId)) != null) {
						incrementId++;
					}
					staff.setUserId("SF-" + staffService.getStaffCount() + incrementId);
				}
				staff.setPost(1);
				staffService.addStaff(staff);
				String redirPage;
				if (httpSession.getAttribute("user") != null) {
					redirPage = "redirect:/staffPage";
				} else {
					redirPage = "redirect:/";
				}
				return redirPage;	
	}
	
	@RequestMapping(value = "editStaff", method = RequestMethod.GET)
	public ModelAndView editStaff(HttpSession httpSession, @ModelAttribute("command") Staff staff,
			BindingResult bindingResult) throws ParseException {
		if (httpSession.getAttribute("user") != null && (Integer) httpSession.getAttribute("post") == 1) {
			ModelAndView model = new ModelAndView("staffPage");
			Staff editStaff = staffService.getStaff(staff.userId);
			 
			model.addObject("staff", editStaff);
			model.addObject("departments", departmentService.getDepartment());
			model.addObject("staffList", staffService.getStaff());
			return model;
		}

		return new ModelAndView("redirect:/");

	}
}
