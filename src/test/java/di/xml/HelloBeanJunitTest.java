package di.xml;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class HelloBeanJunitTest {

	@Autowired
	private ApplicationContext context;

	@Test
	public void test1() {

		Hello hello1 = context.getBean("helloWithProperty", Hello.class);
		Hello hello2 = (Hello) context.getBean("helloWithProperty");
		hello1.print(); // hello1이 가진 stringPrinter의 stringBuffer에 sayHello 값이 appned 된 상태

		assertSame(hello1, hello2);
		assertEquals(hello1.sayHello(), "Hello Spring");

		Printer printer = context.getBean("stringPrinter", StringPrinter.class);
//		Printer printer = hello1.getPrinter();
		assertThat(printer.toString(), is("Hello Spring"));

		assertEquals(hello1.getNames().size(), 3);
		for (String value : hello1.getNames()) {
			System.out.println(value);
		}

		assertEquals(hello1.getNameAndAge().size(), 3);
		for (String key : hello1.getNameAndAge().keySet()) {
			System.out.println("key : " + key + ", value : " + hello1.getNameAndAge().get(key));
		}

	}
}