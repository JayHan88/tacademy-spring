package jay.user.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import jay.user.admin.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

// @Repository("userDao")
public class UserDaoImplJDBC implements UserDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// class for RowMapper interface
	private class UserMapper implements RowMapper<UserVO> {

		// override interface method mapRow
		@Override
		public UserVO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			UserVO userVO = new UserVO();
			userVO.setUserId(resultSet.getString("userId"));
			userVO.setName(resultSet.getString("name"));
			userVO.setGender(resultSet.getString("gender"));
			userVO.setCity(resultSet.getString("city"));
			return userVO;
		}
	}

	@Override
	public UserVO read(String id) {

		String SQL = "select * from users_test where userid = ?";
		try {
			UserVO userVO = jdbcTemplate.queryForObject(SQL, new Object[] { id }, new UserMapper());
			return userVO;
		} catch (EmptyResultDataAccessException e){
			return null;
		}
	}


	@Override
	public void insert(UserVO userVO) {
		String SQL = "insert into users_test (userid, name, gender, city) values (?, ?, ?, ?)";
		jdbcTemplate.update(SQL, userVO.getUserId(), userVO.getName(), userVO.getGender(), userVO.getCity());
	}

	@Override
	public List<UserVO> readAll() {
		String SQL = "select * from users_test";
		List<UserVO> userDtoList = jdbcTemplate.query(SQL, new UserMapper());
		return userDtoList;
	}

	@Override
	public void delete(String id) {
		String SQL = "delete from users_test where userid = ?";
		jdbcTemplate.update(SQL, id);
	}

	@Override
	public void update(UserVO userVO) {
		String SQL = "update users_test set name = ?, gender = ?, city = ? where userid = ?";
		jdbcTemplate.update(SQL, userVO.getName(), userVO.getGender(), userVO.getCity(), userVO.getUserId());
	}

	@Override
	public void deleteAll() {}


}
