package bo;

public class User {
	private String username;
	private String password;
	private String idname;
    public User(){

    }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdname() {
		return idname;
	}
	public void setIdname(String idname) {
		this.idname = idname;
	}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public User(String username, String password, String idname) {
		this.username = username;
		this.password = password;
		this.idname = idname;
	}
	
}
