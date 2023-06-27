package dao;

import java.util.List;
import pojos.Team;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

public class TeamDaoImpl implements TeamDao {

	@Override
	public List<Team> getAllTeams() {
		String jpql="select new pojos.Team(id,abbreviation) from Team";
		List<Team> teams=null;
		// 1. get session from SF
		Session session=getFactory().getCurrentSession();
		//2. begin a tx
		Transaction tx=session.beginTransaction();
		try {
			teams=session.createQuery(jpql, Team.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	
		return teams;
	}

	@Override
	public String addNewTeam(Team newTeam) {
		String mesg="Adding new team failed !!!!";
		// 1. get session from SF
		Session session=getFactory().getCurrentSession();
		//2. begin a tx
		Transaction tx=session.beginTransaction();
		try {
			session.persist(newTeam);
			tx.commit();
			mesg="Added new team with id="+newTeam.getId();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}	
		return mesg;
	}

	@Override
	public Team getTeamDetails(long teamId) {
		Team team=null;
		//1. get session
		Session session=getFactory().getCurrentSession();
		//2. tx
		Transaction tx=session.beginTransaction();
		try {
			team=session.get(Team.class, teamId);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return team;
	}
	
	

}
