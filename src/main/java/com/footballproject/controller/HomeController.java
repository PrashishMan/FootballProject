package com.footballproject.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.footballproject.model.Branch;
import com.footballproject.model.HomePageContent;
import com.footballproject.model.Member;
import com.footballproject.model.Staff;
import com.footballproject.model.SubscriptionPayment;
import com.footballproject.model.Team;
import com.footballproject.services.BookingService;
import com.footballproject.services.BranchService;
import com.footballproject.services.DepartmentService;
import com.footballproject.services.MemberService;
import com.footballproject.services.PaySubscriptionService;
import com.footballproject.services.StaffService;
import com.footballproject.services.SubscriptionService;
import com.footballproject.services.TeamService;

@Controller
public class HomeController {

	@Autowired
	BranchService branchService;

	@Autowired
	MemberService memberService;
	
	@Autowired
	StaffService staffService;

	@Autowired
	TeamService teamService;

	@Autowired
	DepartmentService departmentService;

	@Autowired
	BookingService bookingService;

	@Autowired
	SubscriptionService subscriptionService;

	@Autowired
	PaySubscriptionService paySubscriptionService;
	

	@RequestMapping(value = "/")
	public ModelAndView homePage(HttpSession httpSession) {
		if (httpSession.getAttribute("user") == null) {
			ModelAndView model = new ModelAndView("redirect:/login");
			return model;
		} else {

			///// Code for C panel;
			// This code shall run in every interval to check is user has paid subscription
			///// or not
			runCPanelContent();
			//////////////////////////////////////////////////////////////////////////////////////////

			ModelAndView homeModel = new ModelAndView("home/home");
			assignResources(homeModel, httpSession);
			return homeModel;
		}
	}
	
	public void assignResources( ModelAndView homeModel, HttpSession httpSession) {
		List<Branch> branchList = branchService.getBranch();
		Branch headBranch = branchService.getHeadBranch();

		if (headBranch == null) {
			headBranch = new Branch();
		}
				
		Team team = new Team();
		
		homeModel.addObject("headBranch", headBranch);
		homeModel.addObject("branchList", branchList);
		if ((Integer) httpSession.getAttribute("post") == 1) {
			Staff staff = staffService.getStaff(httpSession.getAttribute("user").toString()); 
			homeModel.addObject("message1", memberService.getMemberCount());
			homeModel.addObject("members", memberService.getMember());
			homeModel.addObject("subscriptionPaidList", paySubscriptionService.getSubscriptionPayment());
			homeModel.addObject("currentDate", new Date());
			
			homeModel.addObject("pageContent", getPageContent());
			httpSession.setAttribute("department", staff.departmentId.departmentName);
		}
		else if((Integer) httpSession.getAttribute("post") == 0) {
			Member member1 = memberService.getMember(httpSession.getAttribute("user").toString());
			homeModel.addObject("member", member1);
			homeModel.addObject("teamList", teamService.getTeam());
			homeModel.addObject("memberBookings", bookingService.getTeamBooked(member1.getTeamName()));
			homeModel.addObject("team", team);
		}
	}
		
	public HomePageContent getPageContent() {
		HomePageContent pageContent = new HomePageContent();
		pageContent.setMemberCount(memberService.getMemberCount());
		pageContent.setTeamCount(teamService.getTeamCount());
		pageContent.setBranchCount(branchService.getBranchCount());
		pageContent.setDepartmentCount(departmentService.getDepartmentCount());
		pageContent.setStaffCount(staffService.getStaffCount());

		pageContent.setBookingCount(40);
		pageContent.setBookedCount(20);

		pageContent.setJuniorSubs(subscriptionService.getSubscription("Full Member", "Junior Member"));
		pageContent.setSeniorSubs(subscriptionService.getSubscription("Full Member", "Senior Member"));
		
		return pageContent;
	}
	
	
	public void runCPanelContent() {
		Member member = null;

		for (Member initMember : memberService.getMember()) {
			initMember.setSubscriptionStatus(0);
			memberService.addMember(initMember);
		}
		for (SubscriptionPayment monDuePayment : paySubscriptionService.getDueTrialSubscriber()) {
			member = monDuePayment.getMemberId();
			if (member != null) {
				member.setSubscriptionStatus(1);
				memberService.addMember(member);
			}
		}
		for (SubscriptionPayment subsPayment : paySubscriptionService.getClearedSubscriber()) {
			member = subsPayment.getMemberId();
			if (member != null) {
				member.setSubscriptionStatus(2);
				memberService.addMember(member);
			}
		}
	}
	
	
}


