package bizImpl;

import action.UserDao;
import action.impl.UserDaoImpl;
import biz.UserBiz;
import model.User;

public class UserBizImpl implements UserBiz {
	private UserDao userDao=null;
	public UserBizImpl() {
		userDao=new UserDaoImpl();
	}


	public User login(User user) {
		return userDao.queryUser(user);
	}

	public int registerUser(User user) {
		if(userDao.queryUser(user)!=null){
			return 1;//此用户已经存在
			
		}else{
			boolean res=userDao.saveUser(user);
			if(res){
				return 2;//注册成功
			}else{
				return 3;//注册失败
			}
				
		}
	
	}

}
