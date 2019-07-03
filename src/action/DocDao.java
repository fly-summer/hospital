package action;

import java.util.List;

import model.Doctor;

public interface DocDao {
	public boolean saveDoc(Doctor doc);//���ҽ��
	public boolean delDoc(int DId);//ɾ��ҽ��
	public boolean updateDoc(Doctor doc);//����ҽ����Ϣ
	public List<Doctor> queryDocs();//��ѯ����ҽ��
	public List<Doctor> queryDocByDName(String DName);//��������ѯҽ��
	public List<Doctor> queryDocByDId(int DId);//�Ա�Ų�ѯҽ��
	public boolean queryDocBySick(String Room,String DName);//����ͨ������������ѯҽ��
}
