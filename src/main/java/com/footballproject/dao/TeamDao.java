package com.footballproject.dao;

import java.util.List;

import com.footballproject.model.Team;

public interface TeamDao {
	public Team getTeam(String teamName);
	public void createTeam(Team team);
	public List<Team> getTeam();
	public int getTeamCount();
}

