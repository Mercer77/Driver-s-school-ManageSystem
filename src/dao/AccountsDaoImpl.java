package dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import entity.Accounts;

public class AccountsDaoImpl extends HibernateDaoSupport implements IAccountsDao {

	@Override
	public void register(Accounts user) {//����Աע��
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Accounts> findAllUser() {//��ѯ���й���Ա�˻�
		// TODO Auto-generated method stub
		List<Accounts> list = (List<Accounts>)this.getHibernateTemplate().find("select u from Accounts u");
		System.out.println(list.get(0).getUsername());
		return list;
	}

}
