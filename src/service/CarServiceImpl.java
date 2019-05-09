package service;

import java.util.List;

import dao.ICarDao;
import entity.Car;

public class CarServiceImpl implements ICarService {
	private ICarDao carDao;
	public ICarDao getCarDao() {
		return carDao;
	}

	public void setCarDao(ICarDao carDao) {
		this.carDao = carDao;
	}

	@Override
	public List<Car> getAll() {
		// TODO Auto-generated method stub
		
		return carDao.getAll();
	}

	@Override
	public List<Car> getOne(String carnum) {
		// TODO Auto-generated method stub
		return carDao.getOne(carnum);
	}

}
