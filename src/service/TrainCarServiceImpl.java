package service;

import java.util.List;

import dao.ITrainCarDao;
import entity.Traincar;
import entity.TraincarId;

public class TrainCarServiceImpl implements ITrainCarService {
	private ITrainCarDao traincarDao;
	
	public ITrainCarDao getTraincarDao() {
		return traincarDao;
	}

	public void setTraincarDao(ITrainCarDao traincarDao) {
		this.traincarDao = traincarDao;
	}

	
	@Override
	public boolean add(Traincar traincar) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			traincarDao.add(traincar);
			flag=true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Traincar> getAlls() {
		// TODO Auto-generated method stub
		return traincarDao.getAlls();
	}

	@Override
	public List<Traincar> getOne(String cnum) {
		// TODO Auto-generated method stub
		return traincarDao.getOne(cnum);
	}

	@Override
	public boolean delete(Traincar traincar) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			traincarDao.delete(traincar);
			flag=true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Traincar traincar) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			traincarDao.update(traincar);
			flag=true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}



}
