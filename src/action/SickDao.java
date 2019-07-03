package action;

import java.util.List;

import model.Sick;

public interface SickDao {
	public boolean saveSick(Sick sick);//��ӻ���
	public boolean delSick(int SId);//ɾ������
	public boolean updateSick(Sick sick);//���»�����Ϣ
	public List<Sick> querySick();//��ѯ���л���
	public List<Sick> queryDocBySName(String SName);//��������ѯ����
	public Sick queryDocBySId(int SId);//�Ա�Ų�ѯ����
}
