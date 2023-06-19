package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Department;
import pojos.Employee;
import static utils.HibernateUtils.getFactory;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String addNewEmployee(Employee emp, long deptId) {
		String mesg = "adding emp failed!!!!!!!!!!!";
		// 1 get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			// get persistent dept from db
			Department dept = session.get(Department.class, deptId);
			if (dept != null) {
				// dept : PERSISTENT
				// add emp ref to dept's AL
//				dept.getEmpList().add(emp);// parent ---> emp
				// add dept ref to the emp
//				emp.setAssignedDept(dept); // child --> parent'
				dept.addEmployee(emp);		//if we comment this line then --> record with null ->why? where you established the refernces and it is our job to add references 
				// save emp rec
			//	session.persist(emp);
				
				//if we comment line of persist here 
				//still cascade does job for us 
				//No longer req - since cascade : all ...remain can see refer todays lab work
				
				mesg = "Added new emp to Dept " + dept.getDepartmentName();
			}
			tx.commit(); //hb performs dc -- finds status of dept updated -- finds new emp ref in l1 cahce -- auto fires insert query w/o explictly
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String deleteEmpDetails(String deptName, String empEmail)
	{
		String mesg = "deleteing  emp details failed!!!!!!!!!!!";
		String deptJpql="select d from Department d where d.departmentName=:nm";
		String empJqpl="select e from Employee e where e.email=:em";
		// 1 get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			Department dept=session.createQuery(deptJpql, Department.class)
					.setParameter("nm", deptName)
					.getSingleResult();
			Employee emp=session.createQuery(empJqpl, Employee.class)
					.setParameter("em", empEmail)
					.getSingleResult();
			// dept , emp  : persistent
			dept.removeEmployee(emp);
			tx.commit();	
			mesg="Deleted emp details ....";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	@Override
	public Employee getEmpDetails(long empId) {
		Employee emp=null;
		// 1 get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			emp=session.get(Employee.class, empId); //persistent
			tx.commit();			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return emp;//emp : (in case of valid id) : DETACHED
	}
	
	

}
