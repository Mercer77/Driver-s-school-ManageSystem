package service;

import entity.Accounts;

public interface IAccountsService {
	boolean login(String username,String password);//����Ա��½
	boolean register(Accounts user);//����Աע��
	boolean validateUsername(String username);//�жϹ���Ա�û����Ƿ��Ѵ���
}
