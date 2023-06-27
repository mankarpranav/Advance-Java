package dao;

import pojos.Player;
import java.util.List;
import pojos.Team;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addPlayerToTeam(Player newPlayer, long teamId) {
		String mesg="Adding player failed!!!!!";
		// 1. get session from SF
		Session session=getFactory().getCurrentSession();
		//2. begin a tx
		Transaction tx=session.beginTransaction();
		try {
			//get team from team id
			Team team=session.get(Team.class, teamId);
			if(team != null)
			{
				team.addPlayer(newPlayer);
				mesg="Added palyer to the team !";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	
		return mesg;
	}

}
