package dependent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dependency.Transport;

//singleton n eager, id="my_atm" , dep : http
@Component("my_atm")
public class ATMImpl implements ATM {
	@Autowired//(required = false) //matches by data type of the prop : byType
	@Qualifier("soap") //byName
	private Transport myTransport;


	public ATMImpl() {		
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);// null !
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
	}

	// custom init method
	@PostConstruct
	public void myInit() {
		System.out.println("in init " + myTransport);// not null
	}

	// custom destroy method
	@PreDestroy
	public void myDestroy() {
		System.out.println("in destroy " + myTransport);// not null
	}
}
