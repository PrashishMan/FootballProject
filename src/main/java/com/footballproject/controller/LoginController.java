package com.footballproject.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footballproject.model.Member;
import com.footballproject.model.Staff;
import com.footballproject.model.User;
import com.footballproject.services.MemberService;
import com.footballproject.services.StaffService;

@Controller
public class LoginController {

	@Autowired
	MemberService memberService;

	@Autowired
	StaffService staffService;

	private static int userType = -1;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView Login(HttpSession httpSession, RedirectAttributes redirectAttribute) {
		if (httpSession.getAttribute("user") == null) {
			User user = new User();
			ModelAndView model = new ModelAndView("login/login");
			model.addObject("user", user);
			model.addObject("loginType", userType);
			return model;
		}
		ModelAndView homeModel = new ModelAndView("redirect:/");
		return homeModel;
	}

	@RequestMapping(value = "login/{userType}", method = RequestMethod.POST)
	public ModelAndView verifyUser(HttpSession httpSession, @Valid User user, BindingResult bindingResult,
			RedirectAttributes redirAtt, @PathVariable("userType") int userType) {
		if (user != null) {
			if (bindingResult.hasErrors()) {
				redirAtt.addFlashAttribute("message", "loginFailed!!");
				return new ModelAndView("redirect:/");
			}

			User validUser = null;
			if (userType == 0) {
				validUser = (Member) memberService.getMember(user.getUserId());
				userType = 0;

			} else if (userType == 1) {
				validUser = (Staff) staffService.getStaff(user.getUserId());
				userType = 1;
			}

			if (validUser != null) {
				if (validUser.getPassword().equals(user.getPassword())) {
					httpSession.setAttribute("user", validUser.getUserId());
					httpSession.setAttribute("post", validUser.getPost());
					return new ModelAndView("redirect:/");
				} else {
					redirAtt.addFlashAttribute("message", "Invalid Password!!");
				}
			} else {
				redirAtt.addFlashAttribute("message", "Invalid Username!!");
			}
		}

		return new ModelAndView("redirect:/");

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession httpSession) {
		httpSession.setAttribute("user", null);
		httpSession.setAttribute("post", null);

		return new ModelAndView("redirect:/");
	}
	
	

}
