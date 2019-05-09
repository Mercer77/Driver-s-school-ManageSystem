package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IOrderTestDao;
import entity.Ordertest;

public class OrderTestServiceImpl implements IOrderTestService {
	private IOrderTestDao ordertestDao;
	public IOrderTestDao getOrdertestDao() {
		return ordertestDao;
	}

	public void setOrdertestDao(IOrderTestDao ordertestDao) {
		this.ordertestDao = ordertestDao;
	}

	
	@Override
	public boolean add(Ordertest ot) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			ordertestDao.add(ot);
			flag=true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
		
	@Override
	public List<Ordertest> findAllOrder() {
		// TODO Auto-generated method stub
		return ordertestDao.findAllOrder();
	}

	@Override
	public List<Ordertest> findOneById(int id) {
		// TODO Auto-generated method stub
		
		return ordertestDao.findOneById(id);
	}

	@Override
	public boolean delete(Ordertest ot) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			ordertestDao.delete(ot);
			flag=true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Ordertest ot) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			ordertestDao.update(ot);
			flag=true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Ordertest> getSearch(String text) {
		// TODO Auto-generated method stub
		return ordertestDao.getSearch(text);
	}

}
