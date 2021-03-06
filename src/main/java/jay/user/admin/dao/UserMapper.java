package jay.user.admin.dao;

import java.util.List;
import jay.user.admin.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	void insertUser(UserVO userVO);

	List<UserVO> selectUserList();

	void deleteUser(String id);

	void updateUser(UserVO userV);

	UserVO selectUserById(String id);

	void deleteAll();

}
