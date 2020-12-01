package jay.user.admin.test;

import static org.junit.Assert.assertEquals;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;
import java.sql.SQLException;
import javax.sql.DataSource;
import jay.user.admin.service.UserService;
import jay.user.admin.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class UserClientTest {

	@Autowired
	ApplicationContext context;

	@Test
	public void dataSourceTest() {
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Autowired
	UserService userService;

	@Test
	public void getUserTest() {
		UserVO userVO = userService.getUser("gildong");
		System.out.println(userVO);
		assertEquals("홍길동", userVO.getName());
	}

	@Test
	public void insertUserTest() {
		userService.insertUser(new UserVO("dooly2", "둘리", "M", "Ulsan"));
		assertEquals("둘리", userService.getUser("dooly2").getName());
	}

	@Test
	public void updateUserTest() {
		userService.updateUser(new UserVO("dooly2", "수정둘리", "M", "Ulsan"));
		assertEquals("수정둘리", userService.getUser("dooly2").getName());
	}

	@Test
	public void deleteUserTest() {
		userService.deleteUser("dooly");
	}

}
