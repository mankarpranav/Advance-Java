package dao;

import java.sql.SQLException;

import pojos.User;

public interface UserDao {
    // Add a method for user authentication (login)
    User authenticateUser(String email, String password) throws SQLException;
}

// HOMEWORK:

// In the dao interface, add a new method for user registration
// The return type for DML (Data Manipulation Language) is String

// Implementation class - use PreparedStatement (pst2)
// Set input parameters except for ID, status, and role
// Execute the update using executeUpdate method
// Return the row count as a String

// Initialize the Dao instance in the init method
// Clean up resources in the destroy method
// Handle doPost method - set the content type and get PrintWriter

// Read parameters from the request

// Implement the registration logic inside the doPost method
// Use the UserDao instance to register the user by invoking the newly added method
