package dao;

import java.util.List;

import entity.Jxstudents;
import entity.Ordertest;

public interface IOrderTestDao {
	void add(Ordertest ot);//���ԤԼ��Ϣ
	List<Ordertest> findAllOrder();//��ѯ����ԤԼ��Ϣ
	List<Ordertest> findOneById(int id);//��id��ѯһ��ԤԼ����Ϣ
	void delete(Ordertest ot);//ɾ��y
	void update(Ordertest ot);//�޸�ԤԼ��Ϣ
	List<Ordertest> getSearch(String text);//������ģ����ѯ��Ϣ
	
}
