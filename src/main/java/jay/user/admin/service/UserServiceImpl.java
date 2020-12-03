package jay.user.admin.service;

import java.util.List;
import jay.user.admin.dao.UserDao;
import jay.user.admin.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public void insertUser(UserVO userVO) {
		userDao.insert(userVO);
	}

	@Override
	public List<UserVO> getUserList() {
		return userDao.readAll();
	}

	@Override
	public void deleteUser(String id) {
		userDao.delete(id);
	}

	@Override
	public UserVO getUser(String id) {
		return userDao.read(id);
	}

	@Override
	public void updateUser(UserVO userVO) {
		userDao.update(userVO);
	}

	@Override
	public void deleteAll() { }
}
