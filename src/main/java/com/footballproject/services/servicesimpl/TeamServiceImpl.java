package com.footballproject.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.footballproject.dao.TeamDao;
import com.footballproject.model.Team;
import com.footballproject.services.TeamService;

@Service("teamService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TeamServiceImpl implements TeamService{

	@Autowired
	TeamDao teamDao;
	
	@Override
	@Transactional(readOnly = false)
	public void createTeam(Team team) {
		teamDao.createTeam(team);
	}

	@Override
	public Team getTeam(String teamName) {
		return teamDao.getTeam(teamName);
	}

	@Override
	public List<Team> getTeam() {
		return teamDao.getTeam();
	}

	@Override
	public int getTeamCount() {
		return teamDao.getTeamCount();
	}

}
