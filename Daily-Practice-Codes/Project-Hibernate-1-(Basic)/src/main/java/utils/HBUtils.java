package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HBUtils {
	
	//singleton object
	private static SessionFactory factory;
	
	static {
		factory = new Configuration().configure().buildSessionFactory();
	}

	public static SessionFactory getFactory() {
		return factory;
	}	
	
}
