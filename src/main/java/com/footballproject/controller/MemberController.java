package com.footballproject.controller;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.footballproject.model.Member;
import com.footballproject.model.Subscription;
import com.footballproject.model.SubscriptionPayment;
import com.footballproject.services.MemberService;
import com.footballproject.services.PaySubscriptionService;
import com.footballproject.services.SubscriptionService;
import com.footballproject.services.TeamService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@Autowired
	PaySubscriptionService paySubscriptionService;
	
	@Autowired
	TeamService teamService;

	@Autowired
	SubscriptionService subscriptionService;

	@RequestMapping(value = "registerMember", method = RequestMethod.POST)
	public String registerMember(HttpSession httpSession, @ModelAttribute Member member,
			BindingResult bindingResult) {
		// set id increment value to 0
		if (member.userId == null || member.userId.isEmpty()) {
			int incrementId = 0;
			// when these is already available member with given member id set the increment
			// the Id
			while (memberService.getMember("MB-" + (memberService.getMemberCount() + incrementId)) != null) {
				incrementId++;
			}
			member.setUserId("MB-" + memberService.getMemberCount() + incrementId);
		}
		memberService.addMember(member);
		String redirPage;
		if (httpSession.getAttribute("user") != null) {
			redirPage = "redirect:/membersPage";
		} else {
			redirPage = "redirect:/";
		}
		return redirPage;
	}
	
	@RequestMapping(value = "membersPage", method = RequestMethod.GET)
	public ModelAndView getMemberPage(HttpSession httpSession, @ModelAttribute("command") Member member,
			BindingResult bindingResult) {
		if (httpSession.getAttribute("user") != null && (Integer) httpSession.getAttribute("post") == 1) {
			ModelAndView model = new ModelAndView("membersPage");
			model.addObject("members", memberService.getMember());
			model.addObject("newMembersList", memberService.getNewMember());
			return model;
		}

		return new ModelAndView("redirect:/");

	}
	
	@RequestMapping(value = "editMember", method = RequestMethod.GET)
	public ModelAndView editMember(HttpSession httpSession, @ModelAttribute("command") Member member,
			BindingResult bindingResult) throws ParseException {
		if (httpSession.getAttribute("user") != null && (Integer) httpSession.getAttribute("post") == 1) {
			ModelAndView model = new ModelAndView("membersPage");
			Member editMember = memberService.getMember(member.userId);
			model.addObject("member", editMember);
			model.addObject("members", memberService.getMember());
			model.addObject("newMembersList", memberService.getNewMember());
			model.addObject("teams", teamService.getTeam());
			return model;
		}

		return new ModelAndView("redirect:/");

	}

	@RequestMapping(value = "updateMember")
	public ModelAndView updateMember(HttpSession httpSession, @ModelAttribute Member member,
			BindingResult bindingResult) {
		if (httpSession.getAttribute("user") != null && (Integer) httpSession.getAttribute("post") == 1) {
			Member updateMember = memberService.getMember(member.userId);
			updateMember.setPassword(updateMember.userId);
			updateMember.setState(1);
			memberService.addMember(updateMember);

			SubscriptionPayment subscriptionPayment = new SubscriptionPayment(updateMember,
					getMembersSubscription(updateMember));
			paySubscriptionService.addSubscriptionPayment(subscriptionPayment);
			this.updateMembersTable(updateMember);
			return new ModelAndView("redirect:/membersPage");

		}
		return new ModelAndView("redirect:/");
	}

	

	public Subscription getMembersSubscription(Member member) {
		String memberType = null;
		if ((new Date().getYear() - member.getDateOfBirth().getYear()) < 15) {
			memberType = "Junior Member";
		} else {
			memberType = "Senior Member";
		}
		int id = subscriptionService.getSubscriptionId(member.getMemberShipType(), memberType);
		return subscriptionService.getSubscription(id);

	}

	public void updateMembersTable(Member member) {
		member.setSubscriptionStatus(2);
		memberService.addMember(member);
	}
}
