package dao;

import java.util.List;

import entity.Accounts;

public interface IAccountsDao {
	 List<Accounts> findAllUser();//查询所有管理员信息
	 void register(Accounts user);//管理员注册
}
