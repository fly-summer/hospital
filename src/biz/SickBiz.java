package biz;

import java.util.List;

import model.Sick;

public interface SickBiz {
	public boolean addSick(Sick sick);//添加患者
	public boolean delSick(int SId);//删除患者
	public boolean modifySick(Sick sick);//修改患者信息
	public List<Sick> queryAllSick();//查询所有患者
	public List<Sick> querySickBySName(String SName);//根据患者名查询
	public Sick querySickBySId(int SId);//根据编号查询患者信息
	
}
