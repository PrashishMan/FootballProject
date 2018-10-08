package com.footballproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.footballproject.model.Member;
import com.footballproject.services.MemberService;
import com.footballproject.services.SubscriptionService;

@Controller
public class RegistrationController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	SubscriptionService subscriptionService;

	@RequestMapping(value = "register")
	public ModelAndView fillRegistreation(HttpSession httpSession) {
		if (httpSession.getAttribute("user") == null) {
			Member member = new Member();
			ModelAndView model = new ModelAndView("registration");
			model.addObject(member);
			return model;
		}
		return new ModelAndView("redirect:/");
	}

	
	@RequestMapping(value = "subscription")
	public ModelAndView getSubscription(HttpSession httpSession, @ModelAttribute Member member,
			BindingResult bindingResult) {
		if (httpSession.getAttribute("user") == null) {

			ModelAndView model = new ModelAndView("registration");
			model.addObject(member);
			return model;
		}
		return new ModelAndView("redirect:/");
	}

	
}
