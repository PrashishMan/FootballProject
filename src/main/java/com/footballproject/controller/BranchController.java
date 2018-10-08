package com.footballproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.footballproject.model.Branch;
import com.footballproject.model.Department;
import com.footballproject.model.Staff;
import com.footballproject.model.Subscription;
import com.footballproject.services.BookingService;
import com.footballproject.services.BranchService;
import com.footballproject.services.DepartmentService;
import com.footballproject.services.StaffService;
import com.footballproject.services.SubscriptionService;

@Controller
public class BranchController {

	@Autowired
	BranchService branchService;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	StaffService staffService;

	@RequestMapping(value = "/createHeadBranch", method = RequestMethod.POST)
	public String createHeadBranch(HttpSession httpSession, @ModelAttribute Branch branch,
			BindingResult bindingResult) {
		
		if (branchService.getHeadBranch() == null && (Integer)httpSession.getAttribute("post") == 1) {
			Staff admin = staffService.getStaff(httpSession.getAttribute("user").toString());
			initiateSubscriptions();
			branch.setIsHeadBranch(true);
			branchService.addBranch(branch);
			
			initiateDepartments(branch);
			admin.setDepartmentId(departmentService.getDepartment(branch.branchId+"-AD"));
			staffService.addStaff(admin);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/branchPage", method = RequestMethod.GET)
	public ModelAndView getBranchPage(HttpSession httpSession ) {
		if ( httpSession.getAttribute("user")!=null && (Integer)httpSession.getAttribute("post") == 1) {
			ModelAndView model = new ModelAndView("branchPage");
			Branch branch = new Branch();
			model.addObject("branch", branch);
			model.addObject("branches", branchService.getBranch());
			return model;
		}
		return new ModelAndView("redirect:/");
		
	}
	
	@RequestMapping(value="/editBranch", method = RequestMethod.GET)
	public ModelAndView editBranchPage(HttpSession httpSession, @ModelAttribute("command") Branch branch, BindingResult bindingResult) {
		if ( httpSession.getAttribute("user")!=null && (Integer)httpSession.getAttribute("post") == 1) {
			ModelAndView model = new ModelAndView("branchPage");
			Branch editBranch = branchService.getBranch(branch.branchId);
			model.addObject("branches", branchService.getBranch());
			model.addObject("branch", editBranch);
			return model;
		}
		return new ModelAndView("redirect:/");
		
	}
	

	@RequestMapping(value = "addBranch", method = RequestMethod.POST)
	public String addBranch(HttpSession httpSession, @ModelAttribute Branch branch, BindingResult bindingResult) {
		if (httpSession.getAttribute("user") != null && (Integer) httpSession.getAttribute("post") == 1) {
			branchService.addBranch(branch);
			Branch updateBranch = new Branch();
			
			ModelAndView model = new ModelAndView("branchPage");
			model.addObject("branch", updateBranch);
			model.addObject("branches", branchService.getBranch());
			return "redirect:/branchPage";
		} else {
			return "redirect:/";
		}
	}
	
	public void initiateSubscriptions() {
		Subscription subscription1 = new Subscription( "Partial Member", "Junior Member", 20);
		Subscription subscription3 = new Subscription( "Full Member", "Junior Member", 40);
		Subscription subscription2 = new Subscription( "Partial Member", "Senior Member", 80);			
		Subscription subscription4 = new Subscription( "Full Member", "Senior Member", 120 );
		
		subscriptionService.addSubscription(subscription1);
		subscriptionService.addSubscription(subscription2);
		subscriptionService.addSubscription(subscription3);
		subscriptionService.addSubscription(subscription4);
	}
	
	public void initiateDepartments(Branch branch) {
		String branchId = branch.branchId;
		Department departmentAD = new Department(branchId+"-AD", branch, "Administrator");
		Department departmentA = new Department(branchId+"-AC", branch, "Accounts");
		Department departmentS = new Department(branchId+"-SE", branch, "Secretary");
		Department departmentCM = new Department(branchId+"-CM", branch, "Center Manager");
		Department departmentHM = new Department(branchId+"-HM", branch, "Head Manager");
		Department departmentR = new Department(branchId+"-RP", branch, "Rececptionist");
		
		departmentService.addDepartment(departmentAD);
		departmentService.addDepartment(departmentA);
		departmentService.addDepartment(departmentS);
		departmentService.addDepartment(departmentCM);
		departmentService.addDepartment(departmentHM);
		departmentService.addDepartment(departmentR);
	}

	
	
}
