package tester;

import static utils.HibernateUtils.getFactory;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import dao.StudentDaoImpl;

public class TesterGetLoginDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {

			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println(dao.studentLogin(sc.next(), sc.next()));

		} catch (RuntimeException ex) {
			ex.printStackTrace();
		}

	}

}
