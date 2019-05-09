package service;

import java.util.List;

import dao.IAccountsDao;
import dao.ICoachesDao;
import entity.Coaches;

public class CoachesServiceImpl implements ICoachesService {
	//DAO对象
	private ICoachesDao coachesDao;
	
	public ICoachesDao getCoachesDao() {
		return coachesDao;
	}

	public void setCoachesDao(ICoachesDao coachesDao) {
		this.coachesDao = coachesDao;
	}
	
	//添加教练信息
	@Override
	public boolean add(Coaches coaches) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			coachesDao.add(coaches);
			flag=true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Coaches> findAllCoaches() {
		// TODO Auto-generated method stub
		return coachesDao.findAllCoaches();
	}

	@Override
	public List<Coaches> findOneByName(String num) {
		// TODO Auto-generated method stub
		return coachesDao.findOneByName(num);
	}

	@Override
	public boolean delete(Coaches coaches) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			coachesDao.delete(coaches);
			flag=true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
		
	}

	@Override
	public boolean update(Coaches coaches) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			coachesDao.update(coaches);
			flag=true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Coaches> getSeacher(String text) {
		// TODO Auto-generated method stub
		return coachesDao.getSeacher(text);
	}

}
