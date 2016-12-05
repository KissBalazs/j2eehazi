package hu.forest.jeehazi.service;

import hu.forest.jeehazi.dao.BaseDao;
import hu.forest.jeehazi.model.Person;

import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */

@ApplicationScoped
@Named("personService")
public class PersonService {

    @Inject
    private BaseDao baseDao;

    public void addPerson(String name, Date birthday) {
        Person person = new Person();
        person.setName(name);
        person.setBirthday(birthday);
        baseDao.save(person);
    }

    public void addPerson(String name) {
        Person person = new Person();
        person.setName(name);
        baseDao.save(person);
    }

    public List<Person> getPersons() {
        return baseDao.query(Person.class, Person.NQ_FIND_ALL_PERSONS);
    }
}
