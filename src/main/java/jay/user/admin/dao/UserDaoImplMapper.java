package jay.user.admin.dao;

import java.util.List;
import jay.user.admin.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImplMapper implements UserDao {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserVO read(String id) {
		return userMapper.selectUserById(id);
	}

	@Override
	public List<UserVO> readAll() {
		return userMapper.selectUserList();
	}

	@Override
	public void insert(UserVO userVO) {
		userMapper.insertUser(userVO);
		System.out.println("등록된 User Id : " + userVO.getUserId() + " Name : " + userVO.getName());
	}

	@Override
	public void update(UserVO userVO) {
		userMapper.updateUser(userVO);
	}

	@Override
	public void delete(String id) {
		userMapper.deleteUser(id);
		System.out.println("삭제 User Id : " + id);
	}

	@Override
	public void deleteAll() {
		userMapper.deleteAll();
	}
}
