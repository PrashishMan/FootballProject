package com.footballproject.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footballproject.model.Booking;
import com.footballproject.model.Branch;
import com.footballproject.model.Member;
import com.footballproject.model.Staff;
import com.footballproject.services.BookingService;
import com.footballproject.services.BranchService;
import com.footballproject.services.MemberService;
import com.footballproject.services.StaffService;

@Controller
public class BookingController {

	@Autowired
	BookingService bookingService;

	@Autowired
	BranchService branchService;

	@Autowired
	MemberService memberService;

	@Autowired
	StaffService staffService;
	
	@RequestMapping(value = "/addBooking", method = RequestMethod.POST)
	public String addBooking(HttpSession httpSession, @ModelAttribute Booking booking, BindingResult bindingResult,
			RedirectAttributes message) {
		if ((Integer) httpSession.getAttribute("post") == 0 && httpSession.getAttribute("user") != null
				&& httpSession.getAttribute("branch") != null) {
			Member member = memberService.getMember(httpSession.getAttribute("user").toString());
			if (member.isOrganizer && member.subscriptionStatus != 0) {
				booking.teamName = member.teamName;
				booking.branchId = branchService.getBranch(httpSession.getAttribute("branch").toString());
				if (!bookingService.isPitchBooked(booking)) {
					bookingService.addBooking(booking);
				} else {
					message.addFlashAttribute("errorMessage",
							"Unable to Reserve booking!! The date and time is already reserved for the pitch");
				}
			} else if (!member.isOrganizer) {
				message.addFlashAttribute("errorMessage",
						"Unable to Reserve booking!! Please consult your team organizer for booking");
			} else {
				message.addFlashAttribute("errorMessage",
						"Unable to Reserve booking!! Make sure you have cleared all your dues");
			}
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/removeBooking", method = RequestMethod.GET)
	public String removeBooking(HttpSession httpSession, @ModelAttribute Booking booking, BindingResult bindingResult,
			RedirectAttributes message) {
		if (httpSession.getAttribute("user") != null && (Integer) httpSession.getAttribute("post") == 0) {
			Booking rmBooking = bookingService.getBooking(booking.bookingId);
			bookingService.removeBooking(rmBooking);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/bookingPage", method = RequestMethod.GET)
	public ModelAndView getBookingPage(HttpSession httpSession, @ModelAttribute("command") Branch branch,
			 BindingResult bindingResult) {
		if (httpSession.getAttribute("user") != null) {
			ModelAndView model = new ModelAndView("bookingPage");
			if ((Integer) httpSession.getAttribute("post") == 0) {
				Branch b = branchService.getBranch(branch.branchId);
				String user = httpSession.getAttribute("user").toString();

				httpSession.setAttribute("branch", branch.branchId);
				Booking booking = new Booking();

				booking.setBranchId(b);
				booking.setTeamName(memberService.getMember(user).getTeamName());

				model.addObject("bookingList", bookingService.getBranchBooked(b));
				model.addObject("booking", booking);

			} else if ((Integer) httpSession.getAttribute("post") == 1) {
				Staff staff = staffService.getStaff(httpSession.getAttribute("user").toString());
				model.addObject("bookingList", bookingService.getBooking());
				model.addObject("staff", staff);
				int tempMonth= new Date().getMonth();
				model.addObject("monthlyBookings", bookingService.monthlyBookingRecord(tempMonth));
			}
			return model;
		}
		return new ModelAndView("redirect:/");
	}

}
