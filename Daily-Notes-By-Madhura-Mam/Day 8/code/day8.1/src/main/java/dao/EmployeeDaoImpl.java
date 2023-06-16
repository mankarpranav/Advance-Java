package dao;

import pojos.Employee;
import pojos.EmploymentType;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.*;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String insertEmployeeDetails(Employee emp) {
		// Emp : TRANSIENT
		String mesg = "Adding emp details failed!!!!!";
		// get session from Session Factory
		Session session = getFactory().openSession();// takes out a
		// conn from the DBCP , wraps it in sesison obj n rets it to the caller
		Session session2 = getFactory().openSession();
		System.out.println(session == session2);// false
		System.out.println("is session open " + session.isOpen() + " connected to db " + session.isConnected());// t t
		// begin a tx
		Transaction tx = session.beginTransaction();
		try {
			Integer id=(Integer)session.save(emp);
			// emp : PERSISTENT : emp ref added to L1 cache , not yet in the DB
			tx.commit();// Hibernate performs auto dirty checking upon commit => session.flush() -->
						// chks any changes in state of L1 cache vs DB
			// Finds a new persistent entity --> insert query fired
			mesg = "Added emp details with ID=" + emp.getEmpId();
			System.out.println("is session open " + session.isOpen() + " connected to db " + session.isConnected());// t
																													// t
			// emp : persistent
		} catch (RuntimeException e) {
			// rollback tx
			if (tx != null)
				tx.rollback();
			// re throw the same exc to the caller : to inform the user
			throw e;
		} finally {				//if finally not provided? collection leak exception!
			// session closing
			if (session != null)
				session.close();// pooled out db cn simply rets to the pool!
		}
		// emp : DETACHED from L1 cache
		System.out.println("is session open " + session.isOpen() + " connected to db " + session.isConnected());// f f
		return mesg;
	}

	@Override
	public String insertEmployeeDetailsCurrentSession(Employee emp) {
		// Emp : TRANSIENT
		String mesg = "Adding emp details failed!!!!!";
		// get session from Session Factory
		Session session = getFactory().getCurrentSession();// takes out a
		// conn from the DBCP , wraps it in sesison obj n rets it to the caller
		Session session2 = getFactory().getCurrentSession();
		System.out.println(session == session2);// t
		// System.out.println("is session open " + session.isOpen() + " connected to db
		// " + session.isConnected());// t t
		// begin a tx
		Transaction tx = session.beginTransaction();
		System.out.println("is session open " + session.isOpen() + " connected to db " + session.isConnected());// t t
		try {
			session.save(emp);
			// emp : PERSISTENT : emp ref added to L1 cache , not yet in the DB
			tx.commit();// Hibernate performs auto dirty checking upon commit => session.flush() -->
						// chks any changes in state of L1 cache vs DB
			// Finds a new persistent entity --> insert query fired , session.close() --> L1
			// cache is destroyed n pooled out db cn rets to the pool
			mesg = "Added emp details with ID=" + emp.getEmpId();
			System.out.println("is session open " + session.isOpen() + " connected to db " + session.isConnected());// f
			// f f						
			// emp : persistent
		} catch (RuntimeException e) {
			// rollback tx
			if (tx != null)
				tx.rollback();// no dirty checking --> session.close --> l1 cache destroyed n db cn rets to pool
			System.out.println("is session open " + session.isOpen() + " connected to db " + session.isConnected());// f
																													// f
			// re throw the same exc to the caller : to inform the user
			throw e;
		}
		// emp : DETACHED from L1 cache
		return mesg;
	}

	@Override
	public Employee getEmpDetails(int empId) {
		Employee emp = null;// emp : NOA
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			emp = session.get(Employee.class, empId);// select
			// un comment below lines to confirm L1 cache!
//			emp=session.get(Employee.class,empId);//cache
//			emp=session.get(Employee.class,empId);//cache
//			emp=session.get(Employee.class,empId);//cache
			// in case of valid id , emp : PERSISTENT
			tx.commit();			//returns Persistent entity
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return emp;// emp : DETACHED
	}		
	//persistent env =>
	@Override
	public List<Employee> getAllEmps() {
		List<Employee> empList = null;
		String jpql = "select e from Employee e";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			empList = session.createQuery(jpql, Employee.class).getResultList();
			// empList : containing list of PERSISTENT entities
			// comment the line below , observe n conclude !
			tx.commit();	//sessionFlush() --> session close() --> connection returns to the pool ; cache removed
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return empList;// empList : containing list of DETACHED entities; //Dao returns the detached entities to the caller
	}

	@Override
	public List<Employee> getEmpsByDateAndSalary(LocalDate begin1, LocalDate end1, double minSal) {
		List<Employee> emps = null;
		String jpql = "select e from Employee e where e.joinDate between :begin and :end and e.salary > :sal";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			emps = session.createQuery(jpql, Employee.class) // Query obj
					.setParameter("begin", begin1) // 1st named in param
					.setParameter("end", end1) // 2nd
					.setParameter("sal", minSal)// 3rd
					.getResultList(); // exec query
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return emps;
	}

	@Override
	public List<String> getEmpLastNamesByType(EmploymentType empType) {
		List<String> names = null;
		String jpql = "select e.lastName from Employee e where e.type=:ty";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			names = session.createQuery(jpql, String.class).setParameter("ty", empType).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return names;
	}

	@Override
	public List<Employee> testConstructorExpression(EmploymentType empType) {
		List<Employee> emps = null;
		String jpql = "select new pojos.Employee(firstName,lastName,salary) from Employee e where e.type=:type1";
		//lift POJO instance having partial info
		//f.Q path --> pojos.Employee
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			emps = session.createQuery(jpql, Employee.class)
					.setParameter("type1", empType)
					.getResultList();
			
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return emps;
	}

	@Override
	public String updateEmpSalary(String email1, String pwd1, double salIncrement) {
		String mesg = "sal updation failed!!!!!!!!";
		Employee emp = null;
		String jpql = "select e from Employee e where e.email=:em and e.password=:pass";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			emp = session.createQuery(jpql, Employee.class)
					.setParameter("em", email1)
					.setParameter("pass", pwd1)
					.getSingleResult();
			//getResultList --> when result list
			//getSingleResult --> only one matching record avail then 
			// emp : PERSISTENT
			emp.setSalary(emp.getSalary() + salIncrement);// updating state of the persistent entity; hibernate --> tracking changes in l1 cache to db; change made --> will fire update query @commit statement
			emp.setJoinDate(emp.getJoinDate().minusMonths(1));
			//only one update query will be fored;
			//Hibernate collects all changes --> delayed writing policy of Hibernate
			tx.commit();// hib performs auto dirty chking upon commit -->session.flush --> DML : update
						// --> session.close
			mesg = "Updated sal of the emp :" + emp.getFirstName() + " " + emp.getLastName();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		//emp : DETACHED from L1 cache
		emp.setSalary(emp.getSalary() + salIncrement);
		return mesg;
	}

}
