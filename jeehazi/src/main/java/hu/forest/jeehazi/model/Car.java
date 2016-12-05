package hu.forest.jeehazi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */

@NamedQueries(
        @NamedQuery(name = Car.FIND_ALL_CARS, query = "select c from Car c")
)
@Entity
@EqualsAndHashCode(callSuper = false)
@Data
public class Car extends BaseEntity{

    public static final String FIND_ALL_CARS = "car.findAll";

    @Basic
    private String brand;

    @Basic
    private String type;

    @Basic
    private String color;

    @Basic
    private int engineCapacity;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date yearOfBuild;

    @ManyToMany(mappedBy = "cars")
    private List<User> renters;


    //Vagy:
//    @OneToMany(mappedBy="car")
//    private List<Rent> rents;


}
