package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;
import pojos.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void registration(Student student) {
		
		//session
		Session session = getFactory().openSession();
		
		//transaction
		Transaction tx = session.beginTransaction();
		
		//try-catch
		try {
			session.save(student);
			tx.commit();		
			
		}catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	}

	@Override
	public String studentLogin(String email, String pass) {
		
		String msg="falied..!";
		//Student obj
		Student obj = null;
				
		//jpql
		String jpql ="select s from Student s where s.email = : em and s.password = : pw";
		//select e from Employee e where e.email=:em and e.password=:pass
		
		//session
		Session session = getFactory().getCurrentSession();
		
		//transaction
		Transaction tx = session.beginTransaction();
		
		//try-catch
		try {
			//create query
			obj = session.createQuery(jpql, Student.class)
					.setParameter("em",email)
					.setParameter("pw",pass)
					.getSingleResult();
			
			//commit
			tx.commit();
			
			msg="Login Succesfull ! Login Details are: "+obj.getFirstName()+" "+obj.getLastName();
						
		}catch(RuntimeException ex){
			if(tx != null)
				tx.rollback();
			throw ex;
		}
		return msg;
		
	}

	@Override
	public List<String> getStudentsFromSpecCourse(Course course) {
		
		String msg="Failed!!!";
		List<String> names=null;
		
		//JPQL
		//select * from student where Course="DBDA";
		String jpql = "select s.firstName from Student s where s.course=:ty";
		
		//dao instance
		StudentDaoImpl dao = new StudentDaoImpl();
		
		//session 
		Session session = getFactory().getCurrentSession();
		
		//transaction
		Transaction tx = session.beginTransaction();
		
//		String hqlQuery = "FROM Student s WHERE s.course = 'DBDA'";
//		List<Student> students = session.createQuery(hqlQuery, Student.class).getResultList();
		
		//try-catch
		try{
		
			names = session.createQuery(jpql,String.class)
					.setParameter("ty", course)
					.getResultList();
			
			tx.commit();
			
		}catch(RuntimeException ex){
			if(tx !=null)
				tx.rollback();
			throw ex;
		}
		
		return names;
	}
}
