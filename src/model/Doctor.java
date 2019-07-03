package model;

public class Doctor {
	private int DId;
	private String Room;
	private String DName;
	
	
	
	public Doctor() {
		super();
	}
	public Doctor(String room, String dName) {
		super();
		Room = room;
		DName = dName;
	}
	public Doctor(int dId, String room, String dName) {
		super();
		DId = dId;
		Room = room;
		DName = dName;
	}
	public int getDId() {
		return DId;
	}
	public void setDId(int dId) {
		DId = dId;
	}
	public String getRoom() {
		return Room;
	}
	public void setRoom(String room) {
		Room = room;
	}
	public String getDName() {
		return DName;
	}
	public void setDName(String dName) {
		DName = dName;
	}
	

}
