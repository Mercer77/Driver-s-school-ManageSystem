package service;

import dao.AccountsDaoImpl;
import dao.IAccountsDao;
import entity.Accounts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
@Transactional
public class AccountsServiceImpl implements IAccountsService {
	//DAO����
	private IAccountsDao accountsDao;
	


	public IAccountsDao getAccountsDao() {
		return accountsDao;
	}

	public void setAccountsDao(IAccountsDao accountsDao) {
		this.accountsDao = accountsDao;
	}

	@Override
	public boolean login(String username, String password) {//����Ա��½
		// TODO Auto-generated method stub
		boolean flag = false;
		List<Accounts> list =new ArrayList<Accounts>();
		try{	
			list =accountsDao.findAllUser();
			for(int i=0;i<list.size();i++){
				if(username.equals(list.get(i).getUsername())&&password.equals(list.get(i).getPassword())){
					flag=true;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean register(Accounts user) {//����Աע��
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			accountsDao.register(user);
			flag=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean validateUsername(String username) {//�жϹ���Ա�û����Ƿ��Ѵ���
		// TODO Auto-generated method stub
		boolean flag = false;
		List<Accounts> list =new ArrayList<Accounts>();
		try{	
			list =accountsDao.findAllUser();
			for(int i=0;i<list.size();i++){
				if(username.equals(list.get(i).getUsername())){
					flag=true;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;

	}

}
