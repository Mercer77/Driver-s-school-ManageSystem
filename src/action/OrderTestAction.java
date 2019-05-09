package action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.jasper.tagplugins.jstl.core.Set;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import entity.Ordertest;
import service.IOrderTestService;
import service.IStudentsService;
@SuppressWarnings("serial")
@Controller
public class OrderTestAction extends ActionSupport {
	private IOrderTestService ordertestService;//Ԥ��ҵ��
	private IStudentsService studentsService;//ѧ��ҵ��
	private Ordertest ordertest;
	
	public Ordertest getOrdertest() {
		return ordertest;
	}
	public void setOrdertest(Ordertest ordertest) {
		this.ordertest = ordertest;
	}
	public IOrderTestService getOrdertestService() {
		return ordertestService;
	}
	public void setOrdertestService(IOrderTestService ordertestService) {
		this.ordertestService = ordertestService;
	}
	public IStudentsService getStudentsService() {
		return studentsService;
	}
	public void setStudentsService(IStudentsService studentsService) {
		this.studentsService = studentsService;
	}
	//��ӿ���ԤԼ��¼
	public String add(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String test = request.getParameter("test");
		String snum= request.getParameter("snum");
		ordertest.setJxstudents(studentsService.findOneByName(snum).get(0));
		ordertest.setTest(test);
		java.util.Set s = new HashSet();
		s.add(ordertest);
		studentsService.findOneByName(snum).get(0).setOrdertests(s);
		boolean result = ordertestService.add(ordertest);
		if(result){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	//ɾ�����Լ�¼
	public String delete(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("name"));
		ordertest = ordertestService.findOneById(id).get(0);
		boolean result = ordertestService.delete(ordertest);
		
		return SUCCESS;
	}
	//���¿��Լ�¼
	public String update() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String test = request.getParameter("test");
		String snum= request.getParameter("snum");
		ordertest.setJxstudents(studentsService.findOneByName(snum).get(0));
		ordertest.setTest(test);

		boolean result = ordertestService.update(ordertest);
		if(result)
		return SUCCESS;
		else
		return INPUT;
	}
}
