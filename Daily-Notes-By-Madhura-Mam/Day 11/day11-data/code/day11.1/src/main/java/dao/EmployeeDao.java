package dao;

import pojos.Employee;

public interface EmployeeDao {
//add new emp
	String addNewEmployee(Employee emp, long deptId);

	// delete emp details
	String deleteEmpDetails(String deptName, String empEmail);

	Employee getEmpDetails(long nextLong);
}
