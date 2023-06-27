package beans;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import dao.PlayerDao;
import dao.PlayerDaoImpl;
import dao.TeamDao;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;

/*
 * http://localhost:8080/day10_lab/process_form.jsp
myTeam=2&fn=a&ln=b&email=a@gmail.com&dob=1999-06-13&avg=56.78&wickets=10
 */
public class IPLBean {
//state : dep : dao
	private TeamDao teamDao;
	private PlayerDao playerDao;
	private long myTeam;
	private String fn;
	private String ln;
	private String email;
	private String dob;
	private double avg;
	private int wickets;

	public IPLBean() {
		// dao instace
		teamDao = new TeamDaoImpl();
		playerDao = new PlayerDaoImpl();
		System.out.println("IPL bean created...");

	}

	// getters n setters
	public TeamDao getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	public long getMyTeam() {
		return myTeam;
	}

	public void setMyTeam(long myTeam) {
		this.myTeam = myTeam;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	// add B.L method to ret list of all teams to the caller(JSP)
	public List<Team> fetchAllTeams() {
		// invoke dao's method
		return teamDao.getAllTeams();
	}

	// add B.L method to add a player upon successful validation
	public String validateAndAddPlayer() {
		// get selected team dtls
		Team selectedTeam = teamDao.getTeamDetails(myTeam);
		if (selectedTeam != null) {
			// valid team
			// validate age
			LocalDate date = LocalDate.parse(dob);
			int age = Period.between(date, LocalDate.now()).getYears();

			if (age < selectedTeam.getMaxAge() && avg > selectedTeam.getBattingAvg()
					&& wickets > selectedTeam.getWicketsTaken()) {
				// valid i/ps --> create player instance : transient n send it to dao
				// String email, String firstName, String lastName, LocalDate dob, double
				// battingAvg, int wicketsTaken
				return playerDao.addPlayerToTeam(new Player(email, fn, ln, date, avg, wickets), myTeam);
			} else
				return "Invalid Player details";
		} else
			return "Invalid Team!!!!!!!!";
	}

}
