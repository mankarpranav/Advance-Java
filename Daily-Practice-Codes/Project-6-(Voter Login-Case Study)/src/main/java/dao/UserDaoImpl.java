package dao;

import java.sql.*;
import static utils.DBUtils.*;

import pojos.User;

public class UserDaoImpl implements UserDao {

    // Fields
    private Connection cn;
    private PreparedStatement pst1;

    public UserDaoImpl() throws SQLException {
        // Open connection
        cn = openConnection();
        
        // Avoid SQL injection and repetitiveness by using PreparedStatement
        pst1 = cn.prepareStatement("select * from users where email=? and password=?");
        System.out.println("UserDaoImpl created!");
    }

    @Override
    public User authenticateUser(String email, String password) throws SQLException {
        // Set IN parameters
        pst1.setString(1, email);
        pst1.setString(2, password);
        
        try (ResultSet rst = pst1.executeQuery()) {
            if (rst.next()) {
                // Success
                /*
                 * int id, String firstName, String lastName, String email, String password, Date dob,
                 * boolean votingStatus, String role
                 */
                // Create a new User object using the values from the result set
                return new User(rst.getInt(1), rst.getString(2), rst.getString(3), email, password,
                        rst.getDate(6), rst.getBoolean(7), rst.getString(8));
            }
        } // ResultSet automatically closed due to try-with-resources
        
        return null;
    }

    public void cleanUp() throws SQLException {
        if (pst1 != null)
            pst1.close();
        closeConnection();
        System.out.println("UserDaoImpl cleaned up!");
    }

}
