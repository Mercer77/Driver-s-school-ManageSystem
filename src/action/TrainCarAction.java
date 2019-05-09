package action;

import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import entity.Traincar;
import entity.TraincarId;
import service.ICarService;
import service.ICoachesService;
import service.ITrainCarService;
@SuppressWarnings("serial")
@Controller
public class TrainCarAction extends ActionSupport {
	private ITrainCarService trainCarService;//车辆分配业务
	private ICoachesService coachesService;//教练业务
	private ICarService carService;//车辆业务
	private Traincar traincar;
	private TraincarId traincarId;
	
	public TraincarId getTraincarId() {
		return traincarId;
	}
	public void setTraincarId(TraincarId traincarId) {
		this.traincarId = traincarId;
	}
	public ICarService getCarService() {
		return carService;
	}
	public void setCarService(ICarService carService) {
		this.carService = carService;
	}
	

	public ITrainCarService getTrainCarService() {
		return trainCarService;
	}
	public void setTrainCarService(ITrainCarService trainCarService) {
		this.trainCarService = trainCarService;
	}
	public ICoachesService getCoachesService() {
		return coachesService;
	}
	public void setCoachesService(ICoachesService coachesService) {
		this.coachesService = coachesService;
	}
	
	public Traincar getTraincar() {
		return traincar;
	}
	public void setTraincar(Traincar traincar) {
		this.traincar = traincar;
	}
	
	public String add(){
		try{
		HttpServletRequest request = ServletActionContext.getRequest();
		String cnum = request.getParameter("cnum");
		String carnum = request.getParameter("carnum");
		java.util.Set<Traincar> s = new HashSet();
		traincarId = new TraincarId();//复合主键id
		traincar = new Traincar();//练车
		
		traincarId.setCar(carService.getOne(carnum).get(0));//放入车辆对象
		traincarId.setCoaches(coachesService.findOneByName(cnum).get(0));//放入教练对象
		
		traincar.setId(traincarId);
		
		s.add(traincar);
		

		
		carService.getOne(carnum).get(0).setTraincars(s);
		coachesService.findOneByName(cnum).get(0).setTraincars(s);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		boolean result = trainCarService.add(traincar);
		if(result)
		return SUCCESS;
		else
		return INPUT;
		}
	
	public String update(){
		boolean result=false;
	
		HttpServletRequest request = ServletActionContext.getRequest();
		String cnum = request.getParameter("cnum");
		String carnum = request.getParameter("carnum");

      // Traincar oldtraincar = trainCarService.getOne(cnum).get(0);
		
		traincar = new Traincar();
		traincarId = new TraincarId();
		traincarId.setCar(carService.getOne(carnum).get(0));
		traincarId.setCoaches(coachesService.findOneByName(cnum).get(0));
		traincar.setId(traincarId);
		System.out.println(traincar);
		System.out.println(traincarId);
		
		result = trainCarService.update(traincar);
		//trainCarService.delete(oldtraincar);
		System.out.println(result);
		
		if(result)
			return SUCCESS;
		else
			return ERROR; 
		
	}
	public String delete(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String name = request.getParameter("name");
		traincar = trainCarService.getOne(name).get(0);
		boolean result = trainCarService.delete(traincar);
		return SUCCESS;
		
	}
}
