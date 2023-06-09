package dao;

import java.sql.SQLException;

import pojos.User;

public interface UserDao {
//add a method for user authentication(login)
	User authenticateUser(String email, String password) throws SQLException;
}


//HOMEWORK :

//dao interface --> new method --> register(user obj)
//return type for dml is string 

//imple class --> pst2
//set in params -- expcept id status roll
//excuteUpdate
//returns row count

//init --> dai instance
//destroy --> cleanUp
//doPost --> setContent, printWriter

//read parameters
//
//
//