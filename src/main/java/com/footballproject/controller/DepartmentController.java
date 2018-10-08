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
import com.footballproject.services.BranchService;
import com.footballproject.services.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	BranchService branchService;

	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "departmentPage", method = RequestMethod.GET)
	public ModelAndView staffPage(HttpSession httpSession) {
		if ((httpSession.getAttribute("user") != null) && ((Integer) httpSession.getAttribute("post") == 1)) {
			ModelAndView model = new ModelAndView("departmentPage");
			Department departmenta = new Department();
			model.addObject("departments", departmentService.getDepartment());
			model.addObject("department", departmenta);
			model.addObject("branches", branchService.getBranch());

			return model;
		}
		return new ModelAndView("redirect:/");

	}

	@RequestMapping(value = "addDepartment", method = RequestMethod.POST)
	public String addDepartment(HttpSession httpSession, @ModelAttribute Department department,
			BindingResult bindingResult) {
		departmentService.addDepartment(department);
		return "redirect:/departmentPage";
	}

	@RequestMapping(value = "editDepartment", method = RequestMethod.GET)
	public ModelAndView editDepartment(HttpSession httpSession, @ModelAttribute("command")Department department,
			BindingResult bindingResult) throws ParseException {
		if (httpSession.getAttribute("user") != null && (Integer) httpSession.getAttribute("post") == 1) {
			ModelAndView model = new ModelAndView("departmentPage");
			Department editDepartment = departmentService.getDepartment(department.departmentId);
			 
			model.addObject("department", editDepartment);
			model.addObject("departments", departmentService.getDepartment());
			model.addObject("branches", branchService.getBranch());
			return model;
		}

		return new ModelAndView("redirect:/");

	}

	

}
