package hu.forest.jeehazi.service;

import hu.forest.jeehazi.model.Car;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.InitialContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 *     Egyszerű webservice. Tutorial:     https://blog.idrsolutions.com/2013/08/creating-and-deploying-a-java-web-service/
 */

@WebService
public class CarWebservice {
    // Így kellene, de sajnos egy jelenleg nyitott glassfish bug miatt nem lehetséges.
    //    @Inject
    //    private CarService carService; sajnos glassfish bug.
    // Workaround: http://stackoverflow.com/questions/8166187/can-i-and-how-lookup-cdi-managed-beans-using-javax-naming-contextlookup-in-ej


    @WebMethod
    public List<String> listCars() {

        BeanManager bm = null;
        try {
            InitialContext context = new InitialContext();
            bm = (BeanManager) context.lookup("java:comp/BeanManager");
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("BeanManager not found fail");
        }
        Bean<CarService> carServiceBean = (Bean<CarService>) bm.getBeans(CarService.class).iterator().next();
        CreationalContext<CarService> ctx = bm.createCreationalContext(carServiceBean);
        CarService carService = (CarService) bm.getReference(carServiceBean, CarService.class, ctx);


        if (carService == null) {
            throw new IllegalArgumentException("Could not find carServiceDao");
        }
        List<Car> carList = carService.getCars();
        List<String> returnList = new ArrayList<String>();
        for (Car car : carList) {
            returnList.add(car.toString());
        }// .stream().map(Car::toString).collect(Collectors.toList()); de a stream apival nem megy a webservice....


        return returnList;
    }

}
