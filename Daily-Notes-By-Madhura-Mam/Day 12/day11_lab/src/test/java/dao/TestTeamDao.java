package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pojos.Team;
import utils.HibernateUtils;

class TestTeamDao {
	private static TeamDao dao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		// build SF n create dao instance
		HibernateUtils.getFactory();// triggers creation of SF
		dao = new TeamDaoImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		HibernateUtils.getFactory().close();
	}

	@Test
	void test() {
		// create team instance : hard coded details
		Team newTeam = new Team("Mumbai Indians", 
				"MI", "Neeta Ambani", 35, 55, 25);
		// invoke dao's method
		String mesg = dao.addNewTeam(newTeam);
		System.out.println(mesg);
		// assert : if id=1
		assertEquals(2, newTeam.getId());
	}
	@Test
	void testGetAllTeams() {
		List<Team> teams = dao.getAllTeams();
		teams.forEach(t ->System.out.println(t.getId()+" "+t.getAbbreviation()));
		assertEquals(2, teams.size());		
	}

}
