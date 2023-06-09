package utils;

import java.sql.*;

public class DBUtils {
	private static Connection cn;

//http://localhost:8080/day2.1/candidate_list --> means 2 req coming from client
	
//open connection
	public static Connection openConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/advjava?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
		//creating connection -- db independent
		
		cn = DriverManager.getConnection(dbURL, "root", "root");
		//100 separate connections will be created if called 100 times ; 
		
		//4-types of drivers -> 4th type of driver we are using
		
		System.out.println("db cn established....");
		return cn;
		//returning connection
	}

//close connection
	public static void closeConnection() throws SQLException{
		if(cn != null)
			cn.close();
		System.out.println("db cn closed....");
	}
}
