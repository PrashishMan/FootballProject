package com.footballproject.services;

import java.util.List;

import com.footballproject.model.Team;

public interface TeamService {
	public void createTeam(Team team);
	public Team getTeam(String teamName);
	public List<Team> getTeam();
	public int getTeamCount();
}
