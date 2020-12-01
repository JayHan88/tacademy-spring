package jay.user.admin.service;

import java.util.List;
import jay.user.admin.vo.UserVO;

public interface UserService {

	public void insertUser(UserVO userVO);

	public List<UserVO> getUserList();

	public void deleteUser(String id);

	public UserVO getUser(String id);

	public void updateUser(UserVO userVO);

}
