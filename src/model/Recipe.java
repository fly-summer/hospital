package model;

public class Recipe {
	private int RId;
	private String DName;
	private String SName;
	private String Re;
	public Recipe(){
		
	}
	




	public Recipe(String dName, String sName) {
		super();
		DName = dName;
		SName = sName;
	}



	public Recipe(String dName, String sName, String re) {
		super();
		DName = dName;
		SName = sName;
		Re = re;
	}
	public Recipe(int rId, String dName, String sName, String re) {
		super();
		RId = rId;
		DName = dName;
		SName = sName;
		Re = re;
	}

	public int getRId() {
		return RId;
	}
	public void setRId(int rId) {
		RId = rId;
	}
	public String getDName() {
		return DName;
	}
	public void setDName(String dName) {
		DName = dName;
	}
	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		SName = sName;
	}
	public String getRe() {
		return Re;
	}
	public void setRe(String re) {
		Re = re;
	}
}
