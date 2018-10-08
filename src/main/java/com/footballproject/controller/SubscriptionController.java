package com.footballproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

@Controller
public class SubscriptionController {

	@Autowired
	PaySubscriptionService paySubscriptionService;

	@Autowired
	SubscriptionService subscriptionService;

	@Autowired
	MemberService memberService;

	@RequestMapping(value = "recordSubscription")
	public String addSubscption(@ModelAttribute SubscriptionPayment payment, BindingResult bindingResult) {
		paySubscriptionService.addSubscriptionPayment(payment);
		return "redirect:/";
	}

	@RequestMapping(value = "paySubscription", method = RequestMethod.GET)
	public ModelAndView paySubscption(HttpSession httpSession, @ModelAttribute Member member1,
			BindingResult bindingResult) {
		if (httpSession.getAttribute("user") != null && (Integer) httpSession.getAttribute("post") == 1) {
			@SuppressWarnings("deprecation")

			Member member = memberService.getMember(member1.userId);
			int difference = new Date().getYear() - member.getDateOfBirth().getYear();
			String membershipType = member.getMemberShipType();
			String memberType = null;
			if (difference < 15) {
				memberType = "Junior Member";
			} else {
				memberType = "Senior Member";
			}

			int subscriptionAmount = subscriptionService.getSubscription(membershipType, memberType);
			ModelAndView model = new ModelAndView("paySubscriptionPage");
			model.addObject("subscriptionAmount", subscriptionAmount);
			model.addObject("memberType", memberType);
			model.addObject("member", member);
			return model;
		}
		return new ModelAndView("redirect:/");

	}

	@RequestMapping(value = "subscriptionPage", method = RequestMethod.GET)
	public ModelAndView getSubscriptionPage(HttpSession httpSession) {
		if (httpSession.getAttribute("user") != null && (Integer) httpSession.getAttribute("post") == 1) {
			ModelAndView model = new ModelAndView("subscriptionPage");
			addSubscriptionContent(model);
			return model;
		} else {
			return new ModelAndView("redirect:/");
		}
	}
	
	@RequestMapping(value = "viewSubscriptionPage", method = RequestMethod.GET)
	public ModelAndView viewSubscriptionPage(HttpSession httpSession) {
		if (httpSession.getAttribute("user") != null && (Integer) httpSession.getAttribute("post") == 1) {
			ModelAndView model = new ModelAndView("viewSubscription");
			
			model.addObject("subscriptionList", subscriptionService.getSubscription());
			return model;
		} else {
			return new ModelAndView("redirect:/");
		}
	}
	
	@RequestMapping(value = "editSubscription", method = RequestMethod.GET)
	public ModelAndView editSubscription(HttpSession httpSession, @ModelAttribute Subscription subscription, BindingResult bindingResult) {
		if (httpSession.getAttribute("user") != null && (Integer) httpSession.getAttribute("post") == 1) {
			ModelAndView model = new ModelAndView("viewSubscription");
			Subscription editSubscription = subscriptionService.getSubscription(subscription.subscriptionId);
			model.addObject("editSubscription", editSubscription);
			model.addObject("subscriptionList", subscriptionService.getSubscription());
			return model;
		} else {
			return new ModelAndView("redirect:/");
		}
	}
	
	@RequestMapping(value = "updateSubscription", method = RequestMethod.POST)
	public ModelAndView updateSubscription(HttpSession httpSession, @ModelAttribute Subscription subscription, BindingResult bindingResult) {
		if (httpSession.getAttribute("user") != null && (Integer) httpSession.getAttribute("post") == 1) {
			subscriptionService.addSubscription(subscription);
			ModelAndView model = new ModelAndView("viewSubscription");
			model.addObject("subscriptionList", subscriptionService.getSubscription());
			return model;
		} else {
			return new ModelAndView("redirect:/");
		}
	}
	
	public void addSubscriptionContent(ModelAndView model) {
		List<SubscriptionPayment> paymentTrialList = new ArrayList<>();
		List<SubscriptionPayment> paymentDueList = new ArrayList<>();
		for(SubscriptionPayment sp : paySubscriptionService.getDueTrialSubscriber()) {
			if(sp.memberId.subscriptionStatus == 1) {
				paymentTrialList.add(sp);
			}
		}
		
		for(SubscriptionPayment sp : paySubscriptionService.getUnpaidSubscriber()) {
			if(sp.memberId.subscriptionStatus == 0) {
				paymentDueList.add(sp);
			}
		}
			
		model.addObject("clearedSubscriber", paySubscriptionService.getClearedSubscriber());
		model.addObject("paymentDueMembers", paymentDueList);
		model.addObject("dueTrialSubscriber",paymentTrialList);
	}

}
