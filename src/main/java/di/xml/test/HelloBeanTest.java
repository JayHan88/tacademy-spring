package di.xml.test;

import di.xml.Hello;
import di.xml.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class HelloBeanTest {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("config/beans.xml");

		Hello hello = context.getBean("helloWithProperty", Hello.class);
		Hello hello2 = (Hello) context.getBean("helloWithProperty");

		System.out.println(hello.sayHello());
		System.out.println(hello == hello2);

		hello.print();

		Printer printer = context.getBean("stringPrinter", Printer.class);
		System.out.println(printer.toString());
	}

}