package service;

import java.util.List;

import entity.Ordertest;

public interface IOrderTestService {
	boolean add(Ordertest ot);//���ԤԼ��Ϣ
	List<Ordertest> findAllOrder();//��ѯ����ԤԼ��Ϣ
	List<Ordertest> findOneById(int id);//��id��ѯһ��ԤԼ����Ϣ
	boolean delete(Ordertest ot);//ɾ��y
	boolean update(Ordertest ot);//�޸�ԤԼ��Ϣ
	List<Ordertest> getSearch(String text);//������ģ����ѯ��Ϣ
}
