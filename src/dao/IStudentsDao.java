package dao;

import java.util.List;

import entity.Jxstudents;

public interface IStudentsDao {
	void add(Jxstudents stu);//���ѧԱ��Ϣ
	List<Jxstudents> findAllStudents();//��ѯ����ѧԱ��Ϣ
	List<Jxstudents> findOneByName(String num);//��ѧ�Ų�ѯһ��ѧԱ����Ϣ
	void delete(Jxstudents stu);//ɾ��ѧԱ
	void update(Jxstudents stu);//�޸�ѧԱ��Ϣ
	List<Jxstudents> getSeacher(String text);//ģ����ѯѧԱ��Ϣ
}
