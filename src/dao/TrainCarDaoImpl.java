package dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import entity.Jxstudents;
import entity.Traincar;
import entity.TraincarId;

public class TrainCarDaoImpl extends HibernateDaoSupport implements ITrainCarDao {

	@Override
	@Transactional(readOnly = false)
	public void add(Traincar traincar) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(traincar);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Traincar> getAlls() {
		// TODO Auto-generated method stub
		List<Traincar> list = (List<Traincar>) this.getHibernateTemplate().find("select t from Traincar t");
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Traincar> getOne(String cnum) {
		// TODO Auto-generated method stub
		List<Traincar> list = (List<Traincar>) this.getHibernateTemplate().find("select t from Traincar t where t.id.coaches.num=?",cnum);
		return list; 	
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Traincar traincar) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(traincar);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Traincar traincar) {
		// TODO Auto-generated method stub
		try{
		//this.getHibernateTemplate().saveOrUpdate(traincar);
		    Query query = getSessionFactory().openSession().createQuery("update Traincar t set t.id.car.carnum = ? where t.id.coaches.num =?");
			query.setParameter(0,traincar.getId().getCar().getCarnum());
			query.setParameter(1, traincar.getId().getCoaches().getNum());
			query.executeUpdate();
		System.out.println("dd");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TraincarId> getidone(String num) {
		// TODO Auto-generated method stub
		List<TraincarId> list = (List<TraincarId>) this.getHibernateTemplate().find("select i from TraincarId t where i.coaches.num=?",num);
		return list; 
	}

}
