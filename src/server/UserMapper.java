package server;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet result, int rowNum) throws SQLException {
		User user= new User(result.getString("Username"), result.getString("Email"),result.getString("Password1")
				,result.getString("Password2"));
		return user;
	}
	
}
