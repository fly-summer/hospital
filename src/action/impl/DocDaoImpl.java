package action.impl;

import java.util.ArrayList;
import java.util.List;

import action.DocDao;
import model.Doctor;

public class DocDaoImpl extends BaseDao implements DocDao {

	@Override
	public boolean saveDoc(Doctor doc) {
		// TODO Auto-generated method stub
		String sql="insert into doctor (DId,Room,DName)values(?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(doc.getDId());
		params.add(doc.getRoom());
		params.add(doc.getDName());
		

		return this.operUpdate(sql, params);
	}

	@Override
	public boolean delDoc(int DId) {
		// TODO Auto-generated method stub
		String sql="delete from doctor where DId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(DId);
		
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateDoc(Doctor doc) {
		// TODO Auto-generated method stub
		String sql="update doctor set Room=?,DName=? where DId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(doc.getRoom());
		params.add(doc.getDName());
		params.add(doc.getDId());
		
		return this.operUpdate(sql, params);
	}

	@Override
	public List<Doctor> queryDocs() {
		// TODO Auto-generated method stub
		List<Doctor> uList=null;
		String sql="select * from doctor ";
		List<Object> params=new ArrayList<Object>();
		try {
	
			uList=this.operQuery(sql, params, Doctor.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size()>0){
			
			return uList;
			
		}
		return null;
	}

	@Override
	public List<Doctor> queryDocByDName(String DName) {
		// TODO Auto-generated method stub
		List<Doctor> uList=null;
		String sql="select DId,Room,DName from doctor where DName=?";
		List<Object> params=new ArrayList<Object>();
	
		params.add(DName);
		try {
	
			uList=this.operQuery(sql, params, Doctor.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size()>0){
			
			return uList;
			
		}
		return null;
		
	}
	

	@Override
	public List<Doctor> queryDocByDId(int DId) {
		// TODO Auto-generated method stub
		List<Doctor> uList=null;
		String sql="select DId,Room,DName from doctor where DId=?";
		List<Object> params=new ArrayList<Object>();
	
		params.add(DId);
		try {
	
			uList=this.operQuery(sql, params, Doctor.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size()>0){
			
			return uList;
			
		}
		return null;
	}
	public boolean queryDocBySick(String Room,String DName){
		List<Doctor> uList=null;
		String sql="select DId,Room,DName from doctor where Room=? and DName=?";
		List<Object> params=new ArrayList<Object>();
	
		params.add(Room);
		params.add(DName);
		try {
			
			uList=this.operQuery(sql, params, Doctor.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size()>0){
			
			return true;
			
		}
		return false;
	}

}
