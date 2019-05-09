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
	private IStudentsService studentsService;//学生业务
	private ICoachesService coachesService;//教练业务
	private Jxstudents students;//学生对象
	private File zp;//图片文件
	private String zpContentType;//上传图片种类
	private String zpFileName;//上传图片文件名
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

	//添加学员
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
	
	//删除学员
	public String delete(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String num = request.getParameter("id");
		students = studentsService.findOneByName(num).get(0);
		boolean result = studentsService.delete(students);
		
		return SUCCESS;
		
	}
	
	//更新学员信息
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
			this.addFieldError("students.num", "编号不能为空，请重新输入！");
			
		}
	}


	@Override
	// 获得HttpServletResponse对象
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		 this.response = response;
	}
}

