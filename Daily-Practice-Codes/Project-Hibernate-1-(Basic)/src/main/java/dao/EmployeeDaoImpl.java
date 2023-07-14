package dao;

import static utils.HBUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void insertEmployee(Employee emp) {
        // Open a new session from the Hibernate session factory
        Session ss = getFactory().openSession();

        // Begin a new transaction
        Transaction tx = ss.beginTransaction();

        try {
            System.out.println("Done! Inserted Successfully!!");
            // Save the employee object to the database
            ss.save(emp);

            // Commit the transaction
            tx.commit();
        } catch (Exception e) {
            // Roll back the transaction in case of an error
            tx.rollback();
            System.out.println("Error in Transaction" + e);
        } finally {
            // Close the session
            if (ss != null)
                ss.close();
        }
    }
}
