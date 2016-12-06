package hu.forest.jeehazi.service;

import hu.forest.jeehazi.dao.BaseDao;
import hu.forest.jeehazi.model.Car;
import hu.forest.jeehazi.model.Rent;
import hu.forest.jeehazi.model.User;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */

@ApplicationScoped
@Named("userService")
public class UserService {

    @EJB
    private BaseDao baseDao;

    public void addUser(String name, String password, String email){
        User userToSave = new User();
        userToSave.setName(name);
        userToSave.setPasswordHash(password);
        userToSave.setEmail(email);
        userToSave.setRents(new ArrayList<Rent>());
        baseDao.save(userToSave);
    }

    public String getLoggedInUserName(){
        return FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    }

    public void deleteUser(User userToDelete){
        baseDao.delete(userToDelete);
    }

    public List<User> getUsers(){
        return baseDao.query(User.class, User.NQ_FIND_ALL_USERS);
    }
}
