package model;

public class Sick {
	private int SId;
	private String SName;
	private String SSex;
	private int SAge;
	private String SI;
	public Sick(){
		
	}
	
	public Sick(String sName, String sSex, int sAge, String sI) {
		super();
		SName = sName;
		SSex = sSex;
		SAge = sAge;
		SI = sI;
	}
	public Sick(int sId, String sName, String sSex, int sAge, String sI) {
		super();
		SId = sId;
		SName = sName;
		SSex = sSex;
		SAge = sAge;
		SI = sI;
	}

	public int getSId() {
		return SId;
	}
	public void setSId(int sId) {
		SId = sId;
	}
	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		SName = sName;
	}
	public String getSSex() {
		return SSex;
	}
	public void setSSex(String sSex) {
		SSex = sSex;
	}
	public int getSAge() {
		return SAge;
	}
	public void setSAge(int sAge) {
		SAge = sAge;
	}
	public String getSI() {
		return SI;
	}
	public void setSI(String sI) {
		SI = sI;
	}
}
