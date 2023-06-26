package tester;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.AppConfig;
import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class)) {
			System.out.println("SC up n running !");
			// deposit funds : B.L
			// get rdy to use atm bean
			ATMImpl ref1 = ctx.getBean("my_atm", ATMImpl.class);// 1st demand
			ref1.deposit(12345);
			ATMImpl ref2 = ctx.getBean("my_atm", ATMImpl.class);// 2nd demand
			System.out.println(ref1 == ref2);// f
		} // ctx.close --> SC shut down --searches for singleton -- destroy -method
			// --invoked -- bean GC
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
