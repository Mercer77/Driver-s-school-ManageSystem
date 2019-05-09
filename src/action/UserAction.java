package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import entity.Accounts;
import service.IAccountsService;
@Controller
public class UserAction extends ActionSupport  {
	 private IAccountsService accountsService;//service对象
	 private Accounts accounts;//Accounts对象
	 private String passwordcf;//确认密码
	 

	public String getPasswordcf() {
		return passwordcf;
	}
	public void setPasswordcf(String passwordcf) {
		this.passwordcf = passwordcf;
	}
	public IAccountsService getAccountsService() {
		return accountsService;
	}
	public void setAccountsService(IAccountsService accountsService) {
		this.accountsService = accountsService;
	}
	public Accounts getAccounts() {
		return accounts;
	}
	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}
	//注册方法
	public String register(){
		boolean result = accountsService.register(accounts);
		
		if(result){
			
			return SUCCESS;
		}
		else{
			return INPUT;
		}
	}
	//登陆方法
	public String login() {
		
		boolean result = accountsService.login(accounts.getUsername(), accounts.getPassword());
		if(result){

			return SUCCESS;
		}
		else{
			return INPUT;
		}
	}


	//注册校验
	public void validateRegister() {
		// TODO Auto-generated method stub
		if(!passwordcf.equals(accounts.getPassword())){
			this.addFieldError("passwordcf", "密码不一致，请重新输入！");
		}
		if(accounts.getUsername().equals("")){
			this.addFieldError("accounts.username", "用户名不能为空，请重新输入！");
			
		}
		if(accounts.getPassword().equals("")){
			this.addFieldError("accounts.password", "密码不能为空，请重新输入！");
		}
		else if(accountsService.validateUsername(accounts.getUsername())){
			this.addFieldError("accounts.username", "用户名已存在，请重新输入！");
		}
		
	}
	//登陆校验
	public void validateLogin() {
		// TODO Auto-generated method stub
		if(accounts.getUsername().equals("")){
			this.addFieldError("accounts.username", "用户名不能为空，请重新输入！");			
		}
		if(accounts.getPassword().equals("")){
			this.addFieldError("accounts.password", "密码不能为空，请重新输入！");
		}
		else if(!accountsService.login(accounts.getUsername(), accounts.getPassword())){
			this.addActionError("用户名或密码错误，请重新输入！");
		}
		
	}

}
