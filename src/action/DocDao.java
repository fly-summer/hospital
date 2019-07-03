package action;

import java.util.List;

import model.Doctor;

public interface DocDao {
	public boolean saveDoc(Doctor doc);//添加医生
	public boolean delDoc(int DId);//删除医生
	public boolean updateDoc(Doctor doc);//更新医生信息
	public List<Doctor> queryDocs();//查询所有医生
	public List<Doctor> queryDocByDName(String DName);//以姓名查询医生
	public List<Doctor> queryDocByDId(int DId);//以编号查询医生
	public boolean queryDocBySick(String Room,String DName);//病人通过科室姓名查询医生
}
