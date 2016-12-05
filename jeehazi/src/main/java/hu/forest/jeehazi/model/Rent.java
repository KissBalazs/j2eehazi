package hu.forest.jeehazi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.StringJoiner;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */
@NamedQueries(
        @NamedQuery(name = Rent.NQ_FIND_ALL_RENTS, query = "select r from Rent r")
)
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Rent extends BaseEntity {

    public static final String NQ_FIND_ALL_RENTS = "rent.findAll";

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="car_id")
    private Car car;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateOfRent;

    @Basic
    private int price;


}
