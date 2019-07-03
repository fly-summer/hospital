package bizImpl;

import java.util.List;

import action.SickDao;
import action.impl.SickDaoImpl;
import biz.SickBiz;
import model.Sick;

public class SickBizImpl implements SickBiz {
	private SickDao sickDao=null;
	public SickBizImpl(){
		sickDao=new SickDaoImpl();
	}

	@Override
	public boolean addSick(Sick sick) {
		// TODO Auto-generated method stub
		return sickDao.saveSick(sick);
	}

	@Override
	public boolean delSick(int SId) {
		// TODO Auto-generated method stub
		return sickDao.delSick(SId);
	}

	@Override
	public boolean modifySick(Sick sick) {
		// TODO Auto-generated method stub
		return sickDao.updateSick(sick);
	}

	@Override
	public List<Sick> queryAllSick() {
		// TODO Auto-generated method stub
		return sickDao.querySick();
	}

	@Override
	public List<Sick> querySickBySName(String SName) {
		// TODO Auto-generated method stub
		return sickDao.queryDocBySName(SName);
	}
	@Override
	public Sick querySickBySId(int SId) {
		// TODO Auto-generated method stub
		return sickDao.queryDocBySId(SId);
	}

}
