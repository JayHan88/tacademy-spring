package di.annotation;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hello {

	@Value("Spring")
	private String name;

//	@Autowired
//	@Qualifier("stringPrinter")
	@Resource(name = "${printer1}")
	private Printer printer;

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() { this.printer.print(sayHello()); }

}
