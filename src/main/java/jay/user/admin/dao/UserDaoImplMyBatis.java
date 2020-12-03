package jay.user.admin.dao;

import java.util.List;
import jay.user.admin.vo.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

// @Repository("userDao")
public class UserDaoImplMyBatis implements UserDao {

	@Autowired
	private SqlSession session;

	@Override
	public UserVO read(String id) {
		return session.selectOne("userNS.selectUserById", id);
	}

	@Override
	public List<UserVO> readAll() {
		return session.selectList("userNS.selectUserList");
	}

	@Override
	public void insert(UserVO userVO) {
		session.update("userNS.insertUser", userVO);
		System.out.println("등록된 User Id : " + userVO.getUserId() + " Name : " + userVO.getName());
	}

	@Override
	public void update(UserVO userVO) {
		session.update("userNS.updateUser", userVO);
	}

	@Override
	public void delete(String id) {
		session.delete("userNS.deleteUser", id);
		System.out.println("삭제 User Id : " + id);
	}

	@Override
	public void deleteAll() {
		session.delete("userNS.deleteAll");
	}
}
