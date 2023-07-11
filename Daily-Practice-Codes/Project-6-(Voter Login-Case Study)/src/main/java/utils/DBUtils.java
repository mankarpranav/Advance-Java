package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection cn;

	/**
	 * Open a database connection
	 * 
	 * @return the opened Connection object
	 * @throws SQLException if a database access error occurs
	 */
	public static Connection openConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/advjava?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
		// Creating connection -- DB independent

		cn = DriverManager.getConnection(dbURL, "root", "root");
		// 100 separate connections will be created if called 100 times

		// 4 types of drivers -> 4th type of driver we are using

		System.out.println("Database connection established.");
		return cn;
		// Returning the Connection object
	}

	/**
	 * Close the database connection
	 * 
	 * @throws SQLException if a database access error occurs
	 */
	public static void closeConnection() throws SQLException {
		if (cn != null)
			cn.close();
		System.out.println("Database connection closed.");
	}
}
