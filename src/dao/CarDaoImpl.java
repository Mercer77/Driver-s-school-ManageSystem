package dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Controller;

import entity.Car;
import entity.Traincar;
@Controller
public class CarDaoImpl extends HibernateDaoSupport implements ICarDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> getAll() {
		// TODO Auto-generated method stub
		List<Car> list = (List<Car>) this.getHibernateTemplate().find("select c from Car c");
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> getOne(String carnum) {
		// TODO Auto-generated method stub
		List<Car> list = (List<Car>) this.getHibernateTemplate().find("select c from Car c where c.carnum=?",carnum);
		return list;
	}

}
