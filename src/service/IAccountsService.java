package service;

import entity.Accounts;

public interface IAccountsService {
	boolean login(String username,String password);//管理员登陆
	boolean register(Accounts user);//管理员注册
	boolean validateUsername(String username);//判断管理员用户名是否已存在
}
