
public interface UserDAO {
	public void create(String userName, String email, String psword, String psword2);
	public User getUser(String email);
	public Boolean logIn(String email, String psword, String psword2);
	public void updateUserName(String userName, final String email);
	public void updatePassword(String pswordOld, String psword2Old, String email,String pswordNew, String psword2New);
}
