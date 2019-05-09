package dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import entity.Jxstudents;

public class StudentsDaoImpl extends HibernateDaoSupport implements IStudentsDao {

	
	//��ѯ����ѧԱ��Ϣ
	@SuppressWarnings("unchecked")
	public List<Jxstudents> findAllStudents() {
		// TODO Auto-generated method stub
		List<Jxstudents> list = (List<Jxstudents>) this.getHibernateTemplate().find("select s from Jxstudents s order by s.num");
		return list;
	}

	@Override
	//���ѧԱ��Ϣ
	@Transactional(readOnly = false)
	public void add(Jxstudents stu) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(stu);
	}
	//ɾ��ѧԱ��Ϣ
	@Override
	@Transactional(readOnly = false)
	public void delete(Jxstudents stu) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(stu);
	}
	//����ѧԱ��Ϣ
	@Override
	@Transactional(readOnly = false)
	public void update(Jxstudents stu) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().merge(stu);
	}
	//��ѧ�Ų�ѯһ��ѧԱ��Ϣ
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
