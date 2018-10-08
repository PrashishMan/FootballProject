package com.footballproject.dao.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footballproject.dao.TeamDao;
import com.footballproject.model.Team;

@Repository("teamDao")
public class TeamDaoImpl implements TeamDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void createTeam(Team team) {
		getSession().saveOrUpdate(team);
	}
	
	@Override
	public Team getTeam(String teamName) {
		return getSession().get(Team.class, teamName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Team> getTeam() {
		return (List<Team>)getSession().createCriteria(Team.class).list();
	}

	@Override
	public int getTeamCount() {
		Query query = getSession().createQuery("SELECT count(*) FROM Team");
		int count = 0;
		if(query.uniqueResult() != null) {
			count = ((Long)query.uniqueResult()).intValue();
		}
		return count;
	}

}
