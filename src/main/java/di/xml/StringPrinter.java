package di.xml;

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
