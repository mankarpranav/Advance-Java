package dao;

import pojos.Employee;

public interface EmployeeDao {
    // Inserts an employee into the database.
    void insertEmployee(Employee emp);
}
