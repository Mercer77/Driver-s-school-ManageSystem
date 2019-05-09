package dao;

import java.util.List;

import entity.Jxstudents;
import entity.Ordertest;

public interface IOrderTestDao {
	void add(Ordertest ot);//添加预约信息
	List<Ordertest> findAllOrder();//查询所有预约信息
	List<Ordertest> findOneById(int id);//按id查询一个预约的信息
	void delete(Ordertest ot);//删除y
	void update(Ordertest ot);//修改预约信息
	List<Ordertest> getSearch(String text);//按姓名模糊查询信息
	
}
