package bo;

public class InterView {
	private String userName;
	private String intro;
	public InterView(String userName, String intro) {
		super();
		this.userName = userName;
		this.intro = intro;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	
}
