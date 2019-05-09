package service;

import java.util.List;

import entity.Coaches;
import entity.Jxstudents;

public interface ICoachesService {
	boolean add(Coaches coaches);//��ӽ�����Ϣ
	List<Coaches> findAllCoaches();//��ѯ���н�����Ϣ
	List<Coaches> findOneByName(String num);//���Ų�ѯһ����������Ϣ
	boolean delete(Coaches coaches);//ɾ������
	boolean update(Coaches coaches);//�޸Ľ�����Ϣ
	List<Coaches> getSeacher(String text);//ģ����ѯ������Ϣ
}
