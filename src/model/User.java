package model;

public class User {
	private int UId;//����Ա�ı��
	private String UName;//����Ա������
	private String UPass;//����Ա������
	//ÿ���඼���и��յĹ��췽����
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
