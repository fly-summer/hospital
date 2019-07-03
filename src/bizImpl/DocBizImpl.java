package bizImpl;

import java.util.List;

import action.DocDao;
import action.impl.DocDaoImpl;
import action.impl.UserDaoImpl;
import biz.DocBiz;
import model.Doctor;

public class DocBizImpl implements DocBiz {
	private DocDao docDao=null;
	public DocBizImpl() {
		super();
		docDao=new DocDaoImpl();
		
	}

	@Override
	public boolean saveDoc(Doctor doc) {
		// TODO Auto-generated method stub
		return docDao.saveDoc(doc);
	}

	@Override
	public boolean delDoc(int DId) {
		// TODO Auto-generated method stub
		return docDao.delDoc(DId);
	}

	@Override
	public boolean updateDoc(Doctor doc) {
		// TODO Auto-generated method stub
		return docDao.updateDoc(doc);
	}

	@Override
	public List<Doctor> queryDocs() {
		// TODO Auto-generated method stub
		return docDao.queryDocs();
	}

	@Override
	public List<Doctor> queryDocByDName(String DName) {
		// TODO Auto-generated method stub
		return docDao.queryDocByDName(DName);
	}

	@Override
	public List<Doctor> queryDocByDId(int DId) {
		// TODO Auto-generated method stub
		return docDao.queryDocByDId(DId);
	}
	@Override
	public boolean queryDocBySick(String Room,String DName){
		return docDao.queryDocBySick(Room, DName);
		
	}

}
