package dependency;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//singleton , lazy , dervied id pattern
@Component //id=httpTransport
@Lazy(true)
public class HttpTransport implements Transport {
	public HttpTransport() {
		System.out.println("in cnstr of " +getClass().getName());
	}

	@Override
	public void informBank(byte[] data) {
		System.out.println("informing bank using " + getClass().getName() + " layer");

	}

}
