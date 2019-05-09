package dao;

import java.util.List;

import entity.Coaches;
import entity.Jxstudents;

public interface ICoachesDao {
	void add(Coaches coaches);//添加教练信息
	List<Coaches> findAllCoaches();//查询所有教练信息
	List<Coaches> findOneByName(String num);//按号查询一个学员的信息
	void delete(Coaches coaches);//删除教练
	void update(Coaches coaches);//修改教练信息
	List<Coaches> getSeacher(String text);//模糊查询教练信息
}
