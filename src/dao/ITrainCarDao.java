package dao;

import java.util.List;

import entity.Traincar;
import entity.TraincarId;

public interface ITrainCarDao {
	void add(Traincar traincar);
	List<Traincar> getAlls();
	List<Traincar> getOne(String cnum);
	void delete(Traincar traincar);
	void update(Traincar traincar);
	List<TraincarId> getidone(String num);
}
