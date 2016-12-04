package hu.forest.jeehazi.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */
@NamedQueries(
        @NamedQuery(name = Person.NQ_FIND_ALL_PERSONS, query = "select p from Person p")
)
@Entity
@EqualsAndHashCode(callSuper = false)
public class Person extends BaseEntity{

    public static final String NQ_FIND_ALL_PERSONS = "person.findAll";

    @Basic
    private String name;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    } // todo: setterek, getteerek....


//    @Basic
//    @Getter
//    @Setter
//    @Temporal(TemporalType.DATE)
//    private Date birthday;
//
//    public void setBirthday(Date birthday){
//        this.birthday = birthday;
//    }
//
//    public Date getBirthday(Date birthday){
//        return this.birthday;
//    }

}
