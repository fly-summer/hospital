package action;

import model.User;

public interface UserDao {
	public boolean saveUser(User user);//�����û�
	public boolean delUser(int id);//ɾ���û�
	public boolean updateUser(User user);//�����û�
	public User queryUser(User user);//��ѯ�û�
}