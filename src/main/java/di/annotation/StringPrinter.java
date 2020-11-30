package di.annotation;

import org.springframework.stereotype.Component;

@Component("stringPrinter")
public class StringPrinter implements Printer {

	private StringBuffer stringBuffer = new StringBuffer();

	@Override
	public void print(String message) {
		stringBuffer.append(message);
	}

	public String toString() {
		return this.stringBuffer.toString();
	}
}
