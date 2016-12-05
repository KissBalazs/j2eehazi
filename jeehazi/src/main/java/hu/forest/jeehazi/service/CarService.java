package hu.forest.jeehazi.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hu.forest.jeehazi.dao.BaseDao;
import hu.forest.jeehazi.model.Car;
import hu.forest.jeehazi.model.Rent;
import hu.forest.jeehazi.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */

@ApplicationScoped
@Named("carService")
public class CarService {

    @Inject
    private BaseDao baseDao;

    public void addCar(String brand, String type, String color, int engineCapacity, Date yearOfBuild){
        Car carToSave = new Car();
        carToSave.setBrand(brand);
        carToSave.setType(type);
        carToSave.setColor(color);
        carToSave.setEngineCapacity(engineCapacity);
        carToSave.setYearOfBuild(yearOfBuild);
        carToSave.setRents(new ArrayList<Rent>());
        baseDao.save(carToSave);    }

    public void deleteCar(Car carToDelete){
        baseDao.delete(carToDelete);
    }

    public List<Car> getCars(){
        return baseDao.query(Car.class, Car.FIND_ALL_CARS);
    }
}
