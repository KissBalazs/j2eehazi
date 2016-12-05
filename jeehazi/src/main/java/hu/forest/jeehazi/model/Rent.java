package hu.forest.jeehazi.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */

@Entity
public class Rent extends BaseEntity{

    @ManyToOne
    @JoinColumn(name="id")
    private Car car;

    @ManyToOne
    @JoinColumn(name="id")
    private User user;


}
