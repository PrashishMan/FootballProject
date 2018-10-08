package com.footballproject.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.footballproject.model.Member;
import com.footballproject.model.Team;
import com.footballproject.services.MemberService;
import com.footballproject.services.TeamService;

@Controller
public class TeamController {
	
	@Autowired
	TeamService teamService;
	
	@Autowired
	MemberService memberService;

	@RequestMapping(value="createTeam", method = RequestMethod.POST)
	public String createTeam(HttpSession httpSession, @ModelAttribute Team team1, BindingResult bindingResult) {
		if (httpSession.getAttribute("user") != null && (Integer)httpSession.getAttribute("post") == 0) {
			Team team = new Team();
			team.setTeamName(team1.getTeamName());
			team.setRegistrationDate(new Date());
			Member member = memberService.getMember(httpSession.getAttribute("user").toString());
			team.setTeamOrganizer(member);
			teamService.createTeam(team);
			member.setTeamName(team);
			memberService.addMember(member);
		} 
		return "redirect:/";
		
	}
	
}
