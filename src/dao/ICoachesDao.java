package dao;

import java.util.List;

import entity.Coaches;
import entity.Jxstudents;

public interface ICoachesDao {
	void add(Coaches coaches);//��ӽ�����Ϣ
	List<Coaches> findAllCoaches();//��ѯ���н�����Ϣ
	List<Coaches> findOneByName(String num);//���Ų�ѯһ��ѧԱ����Ϣ
	void delete(Coaches coaches);//ɾ������
	void update(Coaches coaches);//�޸Ľ�����Ϣ
	List<Coaches> getSeacher(String text);//ģ����ѯ������Ϣ
}
