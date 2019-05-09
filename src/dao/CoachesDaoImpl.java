package dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import entity.Coaches;
import entity.Jxstudents;

public class CoachesDaoImpl extends HibernateDaoSupport implements ICoachesDao {
	
	
	//添加教练信息
	@Override
	@Transactional(readOnly = false)
	public void add(Coaches coaches) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(coaches);
	}
	//查询所有教练信息
	@SuppressWarnings("unchecked")
	@Override
	public List<Coaches> findAllCoaches() {
		// TODO Auto-generated method stub
		List<Coaches> list = (List<Coaches>) this.getHibernateTemplate().find("select c from Coaches c order by c.num");
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	//按num查询一个教练
	public List<Coaches> findOneByName(String num) {
		// TODO Auto-generated method stub
		List<Coaches> list = (List<Coaches>) this.getHibernateTemplate().find("select c from Coaches c where c.num=?",num);
		return list;
	}

	@Override
	@Transactional(readOnly = false)
	//删除学员信息
	public void delete(Coaches coaches) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(coaches);
	}

	@Override
	@Transactional(readOnly = false)
	//更新学员信息
	public void update(Coaches coaches) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().merge(coaches);
	}
	//模糊查询
	@SuppressWarnings("unchecked")
	@Override
	public List<Coaches> getSeacher(String text) {
		// TODO Auto-generated method stub
		List<Coaches> list = (List<Coaches>) this.getHibernateTemplate().find("select c from Coaches c where c.num like '%"+text+"%' or c.name like '%"+text+"%'");
		return list;
	}

}
