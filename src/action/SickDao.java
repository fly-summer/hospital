package action;

import java.util.List;

import model.Sick;

public interface SickDao {
	public boolean saveSick(Sick sick);//添加患者
	public boolean delSick(int SId);//删除患者
	public boolean updateSick(Sick sick);//更新患者信息
	public List<Sick> querySick();//查询所有患者
	public List<Sick> queryDocBySName(String SName);//以姓名查询患者
	public Sick queryDocBySId(int SId);//以编号查询患者
}
