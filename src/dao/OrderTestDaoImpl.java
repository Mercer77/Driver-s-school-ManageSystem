package dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import entity.Ordertest;

public class OrderTestDaoImpl extends HibernateDaoSupport implements IOrderTestDao {

	@Override
	@Transactional(readOnly = false)
	public void add(Ordertest ot) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(ot);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ordertest> findAllOrder() {
		// TODO Auto-generated method stub
		List<Ordertest> list = (List<Ordertest>) this.getHibernateTemplate().find("select o from Ordertest o order by o.time");
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ordertest> findOneById(int id) {
		// TODO Auto-generated method stub
		List<Ordertest> list = (List<Ordertest>) this.getHibernateTemplate().find("select o from Ordertest o where o.id=?",id);
		return list;
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(Ordertest ot) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(ot);
	}

	@Override
	@Transactional(readOnly=false)
	public void update(Ordertest ot) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(ot);
	}

	@Override
	public List<Ordertest> getSearch(String text) {
		// TODO Auto-generated method stub
		List<Ordertest> list = (List<Ordertest>) this.getHibernateTemplate().find("select o from Ordertest o where o.snum like '%"+text+"%' or s.name like '%"+text+"%'");
		return list;
	}

}
