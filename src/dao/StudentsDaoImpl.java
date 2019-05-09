package dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import entity.Jxstudents;

public class StudentsDaoImpl extends HibernateDaoSupport implements IStudentsDao {

	
	//查询所有学员信息
	@SuppressWarnings("unchecked")
	public List<Jxstudents> findAllStudents() {
		// TODO Auto-generated method stub
		List<Jxstudents> list = (List<Jxstudents>) this.getHibernateTemplate().find("select s from Jxstudents s order by s.num");
		return list;
	}

	@Override
	//添加学员信息
	@Transactional(readOnly = false)
	public void add(Jxstudents stu) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(stu);
	}
	//删除学员信息
	@Override
	@Transactional(readOnly = false)
	public void delete(Jxstudents stu) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(stu);
	}
	//更新学员信息
	@Override
	@Transactional(readOnly = false)
	public void update(Jxstudents stu) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().merge(stu);
	}
	//按学号查询一个学员信息
	@SuppressWarnings("unchecked")
	@Override
	public List<Jxstudents> findOneByName(String num) {
		// TODO Auto-generated method stub
		List<Jxstudents> list = (List<Jxstudents>) this.getHibernateTemplate().find("select s from Jxstudents s where s.num=?",num);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Jxstudents> getSeacher(String text) {
		// TODO Auto-generated method stub
		List<Jxstudents> list = (List<Jxstudents>) this.getHibernateTemplate().find("select s from Jxstudents s where s.num like '%"+text+"%' or s.name like '%"+text+"%'");
		return list;
	}

}
