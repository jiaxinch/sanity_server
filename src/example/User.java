
public class User {
	private String username;
	private String email;
	private String password1;
	private String password2;
	private String func;
	public User(){
		
	}
	public void setFunc(String a){
		this.func = a;
	}
	public void setUsername(String a){
		this.username = a;
	}
	public void setEmail(String a){
		this.email = a;
	}
	public void setPassword1(String a){
		this.password1 = a;
	}
	public void setPassword2(String a){
		this.password2 = a;
	}
	public String getUsername(){
		return this.username;
	}
	public String getEmail(){
		return this.email;
	}
	public String getFunc(){
		return this.func;
	}
	public String getPwd1(){
		return this.password1;
	}
	public String getPwd2(){
		return this.password2;
	}
}
