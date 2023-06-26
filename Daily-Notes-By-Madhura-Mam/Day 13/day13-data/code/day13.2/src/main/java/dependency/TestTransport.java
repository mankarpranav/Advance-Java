package dependency;

import org.springframework.stereotype.Component;

//singleton n eager , id=test
@Component("test") //<bean id="test" class="dependency.TestTransport" ..../>
public class TestTransport implements Transport {
	public TestTransport() {
		System.out.println("in cnstr of " +getClass().getName());
	}

	@Override
	public void informBank(byte[] data) {
		System.out.println("informing bank using " + getClass().getName() + " layer");

	}

}
