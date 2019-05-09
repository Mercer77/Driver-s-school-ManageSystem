package service;

import java.util.List;

import entity.Jxstudents;

public interface IStudentsService {
	boolean add(Jxstudents stu);//���ѧԱ��Ϣ
	List<Jxstudents> findAllStudents();//��ѯ����ѧԱ��Ϣ
	List<Jxstudents> findOneByName(String num);//��ѧ�Ų�ѯһ��ѧԱ����Ϣ
	boolean delete(Jxstudents stu);//ɾ��ѧԱ
	boolean update(Jxstudents stu);//�޸�ѧԱ��Ϣ
	List<Jxstudents> getSeacher(String text);//ģ����ѯѧԱ��Ϣ
}
