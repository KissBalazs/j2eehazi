package hu.forest.jeehazi.service;

import hu.forest.jeehazi.dao.BaseDao;
import hu.forest.jeehazi.model.Car;
import hu.forest.jeehazi.model.Rent;
import hu.forest.jeehazi.model.User;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */

@ApplicationScoped
@Named("rentService")
public class RentService {

    @Inject
    private BaseDao baseDao;

    public void addRent(User user, Car car, int price, Date dateOfRent){
        Rent rent = new Rent();
        rent.setPrice(price);
        rent.setDateOfRent(dateOfRent);
        car.getRents().add(rent);
        rent.setCar(car);
        user.getRents().add(rent);
        rent.setUser(user);

        baseDao.save(rent);
//        baseDao.saveRent(rent, user, car);
    }

    public void deleteRent(Rent rentToDelete){
        baseDao.delete(rentToDelete);
    }

    public List<Rent> getRents(){
        return baseDao.query(Rent.class, Rent.NQ_FIND_ALL_RENTS);
    }
}
