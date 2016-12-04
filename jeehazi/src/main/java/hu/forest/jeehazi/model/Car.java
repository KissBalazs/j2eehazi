package hu.forest.jeehazi.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */

@Entity
public class Car extends BaseEntity{
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
