package action.impl;

import java.util.ArrayList;
import java.util.List;

import action.UserDao;
import model.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public boolean saveUser(User user) {
		String sql="insert into user(UId,UName,UPass)values(?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(user.getUId());
		params.add(user.getUName());
		params.add(user.getUPass());
		

		return this.operUpdate(sql, params);
	}

	@Override
	public boolean delUser(int id) {
		String sql="delete from user where UId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateUser(User user) {
		String sql="update user set UName=?,UPass=? where UId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(user.getUName());
		params.add(user.getUPass());
		params.add(user.getUId());
		
		return this.operUpdate(sql, params);
	}

	@Override
	public User queryUser(User user) {
		List<User> uList=null;
		String sql="select UId,UName,UPass from user where UName=? and UPass=?";
		List<Object> params=new ArrayList<Object>();
		params.add(user.getUName());
		params.add(user.getUPass());
		try {
	
			uList=this.operQuery(sql, params, User.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size()>0){
			
			return uList.get(0);
			
		}
		return null;
		
	}

}
