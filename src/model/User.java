package model;

public class User {
	private int UId;//管理员的编号
	private String UName;//管理员的姓名
	private String UPass;//管理员的密码
	//每个类都得有个空的构造方法！
	public User(){
		
	}
	
	public User(String uName, String uPass) {
		super();
		UName = uName;
		UPass = uPass;
	}
	public User(int uId, String uName, String uPass) {
		super();
		UId = uId;
		UName = uName;
		UPass = uPass;
	}

	
	public int getUId() {
		return UId;
	}
	public void setUId(int uId) {
		UId = uId;
	}
	public String getUName() {
		return UName;
	}
	public void setUName(String uName) {
		UName = uName;
	}
	public String getUPass() {
		return UPass;
	}
	public void setUPass(String uPass) {
		UPass = uPass;
	}

}
