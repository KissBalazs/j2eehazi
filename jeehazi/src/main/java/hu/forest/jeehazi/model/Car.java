package hu.forest.jeehazi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */

@NamedQueries(
        @NamedQuery(name = Car.FIND_ALL_CARS, query = "select c from Car c")
)
@Entity
@EqualsAndHashCode(callSuper = false, exclude = "rents")
@ToString(exclude = "rents")
@Data
public class Car extends BaseEntity {

    public Car() {
        this.rents = new ArrayList<Rent>();
    }

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

    @OneToMany(mappedBy = "car")
    private List<Rent> rents;

    public String getPresentationName() {
        return brand + ":" + type;
    }

}
