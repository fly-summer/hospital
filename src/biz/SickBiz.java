package biz;

import java.util.List;

import model.Sick;

public interface SickBiz {
	public boolean addSick(Sick sick);//��ӻ���
	public boolean delSick(int SId);//ɾ������
	public boolean modifySick(Sick sick);//�޸Ļ�����Ϣ
	public List<Sick> queryAllSick();//��ѯ���л���
	public List<Sick> querySickBySName(String SName);//���ݻ�������ѯ
	public Sick querySickBySId(int SId);//���ݱ�Ų�ѯ������Ϣ
	
}
