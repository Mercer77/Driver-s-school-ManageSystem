package service;

import java.util.List;

import entity.Jxstudents;

public interface IStudentsService {
	boolean add(Jxstudents stu);//添加学员信息
	List<Jxstudents> findAllStudents();//查询所有学员信息
	List<Jxstudents> findOneByName(String num);//按学号查询一个学员的信息
	boolean delete(Jxstudents stu);//删除学员
	boolean update(Jxstudents stu);//修改学员信息
	List<Jxstudents> getSeacher(String text);//模糊查询学员信息
}
