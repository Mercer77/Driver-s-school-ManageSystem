package dao;

import java.util.List;

import entity.Accounts;

public interface IAccountsDao {
	 List<Accounts> findAllUser();//��ѯ���й���Ա��Ϣ
	 void register(Accounts user);//����Աע��
}
