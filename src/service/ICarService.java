package service;

import java.util.List;

import entity.Car;

public interface ICarService {
	List<Car> getAll();
	List<Car> getOne(String carnum);

}
