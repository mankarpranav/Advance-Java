package dao;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import utils.HibernateUtils;

class TestAddressDao {
	private static SessionFactory sf;
	private static AddressDao dao;

	@BeforeAll //This method will be called before any of the tests run
	static void myInit() throws Exception {
		System.out.println("before all");
		sf=HibernateUtils.getFactory();
		dao=new AddressDaoImpl();
	}

	@AfterAll //This method will be called after any of the tests run
	static void myDestroy() throws Exception {
		System.out.println("after all");
		sf.close();
	}

	@Test //to indicate following is the test case
	void testUpdateCity() {
		String mesg = dao.updateCity(20, "Indore");
		assertTrue(mesg.contains("successfully"));
	}

}
