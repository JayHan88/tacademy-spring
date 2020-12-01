package jay.user.admin.dao;

import java.util.List;
import jay.user.admin.vo.UserVO;

public interface UserDao {

	public void insert(UserVO userVO);

	public List<UserVO> readAll();

	public void delete(String id);

	public void update(UserVO userV);

	public UserVO read(String id);

}
