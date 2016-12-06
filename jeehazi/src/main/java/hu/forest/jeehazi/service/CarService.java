package hu.forest.jeehazi.service;

import hu.forest.jeehazi.dao.BaseDao;
import hu.forest.jeehazi.model.Car;
import hu.forest.jeehazi.model.Rent;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */

@ApplicationScoped
@Named("carService")
public class CarService {

    @EJB
    private BaseDao baseDao;

    public void addCar(String brand, String type, String color, int engineCapacity, int price, Date yearOfBuild) {
        Car carToSave = new Car();
        carToSave.setBrand(brand);
        carToSave.setType(type);
        carToSave.setColor(color);
        carToSave.setEngineCapacity(engineCapacity);
        carToSave.setPrice(price);
        carToSave.setYearOfBuild(yearOfBuild);
        carToSave.setRents(new ArrayList<Rent>());
        baseDao.save(carToSave);
    }

    public void deleteCar(Car carToDelete) {
        baseDao.delete(carToDelete);
    }

    public List<Car> getCars() {
        return baseDao.query(Car.class, Car.FIND_ALL_CARS);
    }
}
