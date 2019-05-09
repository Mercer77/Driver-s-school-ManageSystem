package dao;

import java.util.List;

import entity.Car;

public interface ICarDao {
	List<Car> getAll();
	List<Car> getOne(String carnum);
}
