package dao;

import static utils.HBUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public void insertEmployee(Employee emp) {
		
		Session ss = getFactory().openSession();
		Transaction tx = ss.beginTransaction();
		
		try{
			System.out.println("Done! Inserted Successfully!!");
			ss.save(emp);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			System.out.println("Error in Transaction"+e);
		}finally {
			if(ss!=null)
				ss.close();
		}
	}	
}
