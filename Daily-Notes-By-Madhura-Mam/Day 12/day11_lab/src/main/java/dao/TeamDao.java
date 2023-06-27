package dao;

import java.util.List;

import pojos.Team;

public interface TeamDao {
//add a method to lift team id n abbreviation from all the tems
	List<Team> getAllTeams();//Hint Ctor expression
	//add new team
	String addNewTeam(Team newTeam);
	//get team details
	Team getTeamDetails(long teamId);
}
