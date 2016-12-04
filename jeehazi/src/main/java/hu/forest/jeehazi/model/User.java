package hu.forest.jeehazi.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */

@Entity
public class User extends BaseEntity{

    @Basic
    private String name;

    @Basic
    private String passwordHash;

    @Basic
    private String email;

    @ManyToMany
    @JoinTable(
            name = "Rent",
            joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
    private List<Car> cars;


    //Vagy:
//    @OneToMany(mappedBy="user")
//    private List<Rent> rents;
}
