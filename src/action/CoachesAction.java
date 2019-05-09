package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import entity.Coaches;
import service.ICoachesService;
@SuppressWarnings("serial")
@Controller
public class CoachesAction extends ActionSupport {
	private ICoachesService coachesService;
	private Coaches coaches;
	private File zp;//图片文件
	private String zpContentType;//上传图片种类
	private String zpFileName;//上传图片文件名

	public ICoachesService getCoachesService() {
		return coachesService;
	}
	public void setCoachesService(ICoachesService coachesService) {
		this.coachesService = coachesService;
	}
	public Coaches getCoaches() {
		return coaches;
	}
	public void setCoaches(Coaches coaches) {
		this.coaches = coaches;
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
	//添加教练
	public String add(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String worktime = request.getParameter("worktime");
		String sex = request.getParameter("sex");
		try{
			String realPath = ServletActionContext.getServletContext().getRealPath("/coachimg");
			File file = new File(realPath,zpFileName);
			FileUtils.copyFile(zp, file);
		}catch(IOException e){
			e.printStackTrace();
		}
		coaches.setZp(zpFileName);
		coaches.setWorktime(worktime);;
		coaches.setSex(sex);
		boolean result = coachesService.add(coaches);
		if(result)
		return SUCCESS;
		else
		return INPUT;	
	}
	//删除教练
	public String delete(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String num = request.getParameter("name");
		coaches = coachesService.findOneByName(num).get(0);
		boolean result = coachesService.delete(coaches);
		return SUCCESS;
	}
	//更新教练信息
	public String update(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String worktime = request.getParameter("worktime");
		String sex = request.getParameter("sex");
		coaches.setWorktime(worktime);
		coaches.setSex(sex);
		coaches.setZp(coachesService.findOneByName(coaches.getNum()).get(0).getZp());
		boolean result = coachesService.update(coaches);
		if(result)
		return SUCCESS;
		else
		return INPUT;	
	}
}
