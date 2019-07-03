package action.impl;

import java.util.ArrayList;
import java.util.List;

import action.SickDao;
import model.Sick;
import model.User;

public class SickDaoImpl extends BaseDao implements SickDao {

	@Override
	public boolean saveSick(Sick sick) {
		String sql="insert into sick(SId,SName,SSex,SAge,SI)values(?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(sick.getSId());
		params.add(sick.getSName());
		params.add(sick.getSSex());
		params.add(sick.getSAge());
		params.add(sick.getSI());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean delSick(int SId) {
		String sql="delete from sick where SId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(SId);

		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateSick(Sick sick) {
		String sql="update sick set SName=?,SSex=?,SAge=?,SI=? where SId=?";
		List<Object> params=new ArrayList<Object>();
		
		params.add(sick.getSName());
		params.add(sick.getSSex());
		params.add(sick.getSAge());
		params.add(sick.getSI());
		params.add(sick.getSId());
		return this.operUpdate(sql, params);
		
	}

	@Override
	public List<Sick> querySick() {
		List<Sick> sList=null;
		String sql="select SId,SName,SSex,SAge,SI from sick";
		List<Object> params=new ArrayList<Object>();
		try {
			sList=this.operQuery(sql, null, Sick.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sList;

	}

	@Override
	public List<Sick> queryDocBySName(String SName) {
		List<Sick> sList=null;
		String sql="select SId,SName,SSex,SAge,SI from sick where SName=?";
		List<Object> params=new ArrayList<Object>();
		params.add(SName);
		try {
			sList=this.operQuery(sql, params, Sick.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sList;
	}

	@Override
	public Sick queryDocBySId(int SId) {
		List<Sick> sList=null;
		String sql="select SId,SName,SSex,SAge,SI from sick where SId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(SId);
		try {
			sList=this.operQuery(sql, params, Sick.class);
		} catch (Exception e) {

			e.printStackTrace();
		}
		if(sList.size()>0){
			return sList.get(0);
		}
		
		return null;

	}

}
