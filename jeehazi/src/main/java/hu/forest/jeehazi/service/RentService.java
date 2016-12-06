package hu.forest.jeehazi.service;

import hu.forest.jeehazi.dao.BaseDao;
import hu.forest.jeehazi.model.Car;
import hu.forest.jeehazi.model.Rent;
import hu.forest.jeehazi.model.User;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */

@ApplicationScoped
@Named("rentService")
public class RentService {

    // @EJB-t nem lehet keverni ha van Inject
    @Inject
    private BaseDao baseDao;

    @Inject
    private UserService userService;

    public void addRent(User user, Car car, int priceMultiplier, Date dateOfRent) {
        Rent rent = new Rent();
        rent.setPrice(car.getPrice() * priceMultiplier);
        if (dateOfRent == null) {
            dateOfRent = new Date();
        }
        rent.setDateOfRent(dateOfRent);
        car.getRents().add(rent);
        rent.setCar(car);
        user.getRents().add(rent);
        rent.setUser(user);

        baseDao.save(rent);
    }

    public void addRent(Car car, int priceMultiplier, Date dateOfRent) {
        String username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser().toString();
        User user = baseDao.findUser(username);
        addRent(user, car, priceMultiplier, dateOfRent);
    }

    public void deleteRent(Rent rentToDelete) {
        baseDao.delete(rentToDelete);
    }

    public List<Rent> getRents() {
        return baseDao.query(Rent.class, Rent.NQ_FIND_ALL_RENTS);
    }

    public List<Rent> getMyRents() {
        String loggedInUserName = userService.getLoggedInUserName();
        return getRents()
                .stream()
                .filter(currentRent -> currentRent.getUser().getName().equals(loggedInUserName))
                .collect(Collectors.toList());
    }
}
