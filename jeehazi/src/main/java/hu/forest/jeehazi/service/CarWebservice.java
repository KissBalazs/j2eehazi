package hu.forest.jeehazi.service;

import hu.forest.jeehazi.model.Car;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */

@WebService
public class CarWebservice {
    @Inject
    private CarService carService;

    @WebMethod
    public Car[] listCars(){
        List<Car> cars = carService.getCars();
        return cars.toArray(new Car[cars.size()]);
    }
    //https://blog.idrsolutions.com/2013/08/creating-and-deploying-a-java-web-service/

}
