package pojos;

public enum Course {
	
	DAC(10000),DBDA(100000),DITISS(10000);
	
	private int fees;
	
	private Course(int fees){
		this.fees=fees;
	}
}
