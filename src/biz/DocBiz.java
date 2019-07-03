package biz;

import java.util.List;

import model.Doctor;


public interface DocBiz {
	public boolean saveDoc(Doctor doc);//���ҽ��
	public boolean delDoc(int DId);//ͨ��DIdɾ��ҽ��
	public boolean updateDoc(Doctor doc);//����ҽ��
	public List<Doctor> queryDocs();//��ѯ����ҽ��
	public List<Doctor> queryDocByDName(String DName);//ͨ��������ѯҽ��
	public List<Doctor> queryDocByDId(int DId);//ͨ��DId��ѯҽ��
	public boolean queryDocBySick(String Room,String DName);//����ͨ������������ѯҽ��
}
