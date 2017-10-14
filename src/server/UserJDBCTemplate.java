package server;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate implements UserDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void create(String userName, String email, String psword, String psword2) {
		String SQL = "insert into User(Username, Email, Password1, Password2) values(?,?,?,?)";
		jdbcTemplateObject.update(SQL,userName,email,psword,psword2);
		
	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean logIn(String email, String psword, String psword2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUserName(String userName, String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePassword(String pswordOld, String psword2Old, String email, String pswordNew, String psword2New) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

}
