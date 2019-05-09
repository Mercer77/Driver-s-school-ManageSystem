package service;

import java.util.List;

import entity.Traincar;
import entity.TraincarId;

public interface ITrainCarService {
	boolean add(Traincar traincar);
	List<Traincar> getAlls();
	List<Traincar> getOne(String cnum);
	boolean delete(Traincar traincar);
	boolean update(Traincar traincar);

}
