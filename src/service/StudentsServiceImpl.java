package service;

import java.util.List;

import dao.IStudentsDao;
import entity.Jxstudents;

public class StudentsServiceImpl implements IStudentsService {
	// DAO对象
	IStudentsDao studentsDao;
	public IStudentsDao getStudentsDao() {
		return studentsDao;
	}

	public void setStudentsDao(IStudentsDao studentsDao) {
		this.studentsDao = studentsDao;
	}

	
	//添加学员信息
	@Override
	public boolean add(Jxstudents stu) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			studentsDao.add(stu);
			flag=true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	//查询所有学员信息
	@Override
	public List<Jxstudents> findAllStudents() {
		// TODO Auto-generated method stub
		return studentsDao.findAllStudents();
	}

	@Override
	public List<Jxstudents> findOneByName(String num) {
		// TODO Auto-generated method stub
		return studentsDao.findOneByName(num);
	}

	@Override
	public boolean delete(Jxstudents stu) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			studentsDao.delete(stu);
			flag=true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Jxstudents stu) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			studentsDao.update(stu);
			flag=true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Jxstudents> getSeacher(String text) {
		// TODO Auto-generated method stub
		return studentsDao.getSeacher(text);
	}

}
