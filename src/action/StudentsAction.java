package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.jasper.tagplugins.jstl.core.Set;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import entity.Jxstudents;
import service.ICoachesService;
import service.IStudentsService;
@SuppressWarnings("serial")
@Controller
public class StudentsAction extends ActionSupport implements ServletResponseAware {
	private IStudentsService studentsService;//ѧ��ҵ��
	private ICoachesService coachesService;//����ҵ��
	private Jxstudents students;//ѧ������
	private File zp;//ͼƬ�ļ�
	private String zpContentType;//�ϴ�ͼƬ����
	private String zpFileName;//�ϴ�ͼƬ�ļ���
	private javax.servlet.http.HttpServletResponse response;
	


	public IStudentsService getStudentsService() {
		return studentsService;
	}

	public void setStudentsService(IStudentsService studentsService) {
		this.studentsService = studentsService;
	}

	public ICoachesService getCoachesService() {
		return coachesService;
	}

	public void setCoachesService(ICoachesService coachesService) {
		this.coachesService = coachesService;
	}

	public Jxstudents getStudents() {
		return students;
	}

	public void setStudents(Jxstudents students) {
		this.students = students;
	}

	public File getZp() {
		return zp;
	}

	public void setZp(File zp) {
		this.zp = zp;
	}

	public String getZpContentType() {
		return zpContentType;
	}

	public void setZpContentType(String zpContentType) {
		this.zpContentType = zpContentType;
	}

	public String getZpFileName() {
		return zpFileName;
	}

	public void setZpFileName(String zpFileName) {
		this.zpFileName = zpFileName;
	}

	//���ѧԱ
	public String add()   {
		HttpServletRequest request = ServletActionContext.getRequest();
		 
		String ksjd = request.getParameter("ksjd");
		String sex = request.getParameter("sex");
		String coach = request.getParameter("coach");
		try{
			String realPath = ServletActionContext.getServletContext().getRealPath("/studimg");
			File file = new File(realPath,zpFileName);
			FileUtils.copyFile(zp, file);
			java.util.Set s = new HashSet();
			students.setCoaches(coachesService.findOneByName(coach).get(0));
			students.setZp(zpFileName);
			students.setKsjd(ksjd);
			students.setSex(sex);
			s.add(students);
			coachesService.findOneByName(coach).get(0).setJxstudentses(s);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		boolean result = studentsService.add(students);
		System.out.println(studentsService);
		if(result)
		return SUCCESS;
		else
		return INPUT;	
		
	}
	
	//ɾ��ѧԱ
	public String delete(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String num = request.getParameter("id");
		students = studentsService.findOneByName(num).get(0);
		boolean result = studentsService.delete(students);
		
		return SUCCESS;
		
	}
	
	//����ѧԱ��Ϣ
	public String update(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String ksjd = request.getParameter("ksjd");
		String sex = request.getParameter("sex");
		String coach = request.getParameter("coach");
		students.setCoaches(coachesService.findOneByName(coach).get(0));
		students.setKsjd(ksjd);
		students.setSex(sex);
		students.setZp(studentsService.findOneByName(students.getNum()).get(0).getZp());
		boolean result = studentsService.update(students);
		if(result)
		return SUCCESS;
		else
		return INPUT;	
		
	}
	
	public void validateAdd(){
		if(students.getNum().equals("")){
			this.addFieldError("students.num", "��Ų���Ϊ�գ����������룡");
			
		}
	}


	@Override
	// ���HttpServletResponse����
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		 this.response = response;
	}
}

