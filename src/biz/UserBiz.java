package biz;

import model.User;

public interface UserBiz {
	//�û���¼�����ص�¼�û�����Ϣ
	public User login(User user);
	//ע���û�
	public int registerUser(User user);
}
