package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;

	public ATMImpl() {
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);
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

	// setter Based D.I
	public void setMyTransport(Transport myTransport) {
		this.myTransport = myTransport;
		System.out.println("in setter");
	}

	// custom init method
	public void myInit() { // spring container - will be called once - @beginning
		System.out.println("in init " + myTransport);// not null
	}

	// custom destroy method
	public void myDestroy() {                       
		System.out.println("in destroy " + myTransport);// not null
	}

}
