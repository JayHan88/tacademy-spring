package jay.user.admin.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import jay.user.admin.dao.UserDao;
import jay.user.admin.service.UserService;
import jay.user.admin.vo.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
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

	@Autowired
	UserService userService;

	@Test
	public void daoTest() {
		UserDao dao = context.getBean("userDao", UserDao.class);

		dao.deleteAll();
		dao.insert(new UserVO("han5517", "Jay", "M", "SEOUL"));
//		dao.update(new UserVO("han5517", "Kate", "F", "Pohang"));
//		dao.delete("han5517");

		List<UserVO> list = dao.readAll();
		for(UserVO userVO : list) {
			System.out.println(userVO);
		}
	}

	// MyBatis config test
	@Test @Ignore
	public void configTest() {
		SqlSession sqlSession = context.getBean("sqlSession", SqlSession.class);
		System.out.println(sqlSession.getClass().getName());

		UserVO userVO = sqlSession.selectOne("userNS.selectById", "gildong");
		System.out.println(userVO);
	}

	@Test @Ignore
	public void dataSourceTest() {
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test @Ignore
	public void getUserTest() {

		UserVO userVO = userService.getUser("gildong");
		System.out.println(userVO);
		assertEquals("홍길동", userVO.getName());
	}

	@Test @Ignore
	public void insertUserTest() {
		userService.deleteAll();
		userService.insertUser(new UserVO("dooly", "둘리", "M", "Ulsan"));
	}

	@Test @Ignore
	public void updateUserTest() {
		userService.updateUser(new UserVO("dooly", "수정둘리", "M", "Ulsan"));
		assertEquals("수정둘리", userService.getUser("dooly2").getName());
	}

	@Test @Ignore
	public void deleteUserTest() {
		userService.deleteUser("dooly");
	}

}
