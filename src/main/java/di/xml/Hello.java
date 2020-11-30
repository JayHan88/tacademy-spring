package di.xml;

import java.util.List;
import java.util.Map;

public class Hello {

	private String name;
	private List<String> names;
	private Printer printer;
	private Map<String, Integer> nameAndAge;

	public Hello() { }

	public Hello(String name, Printer printer, List<String> names, Map<String, Integer> nameAndAge) {
		this.name = name;
		this.printer = printer;
		this.names = names;
		this.nameAndAge = nameAndAge;
	}

	public void print() { this.printer.print(sayHello()); }

	public String sayHello() {
		return "Hello " + name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNames(List<String> names) { this.names = names; }

	public void setPrinter(Printer printer) { this.printer = printer; }

	public void setNameAndAge(Map<String, Integer> nameAndAge) { this.nameAndAge = nameAndAge; }

	public String getName() { return name; }

	public Printer getPrinter() { return printer; }

	public List<String> getNames() { return names; }

	public Map<String, Integer> getNameAndAge() { return nameAndAge; }
}
