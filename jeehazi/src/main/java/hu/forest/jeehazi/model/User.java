package hu.forest.jeehazi.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */

@NamedQueries(
        @NamedQuery(name = User.NQ_FIND_ALL_USERS, query = "select u from User u")
)
@Entity
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {

    public static final String NQ_FIND_ALL_USERS = "user.findAll";

    @Basic
    @Getter
    private String name;

    public void setName(String name){
        this.name = name;
    }


    @Basic
    @Setter
    @Getter
    private String passwordHash;

    @Basic
    @Setter
    @Getter
    private String email;

    @Setter
    @Getter
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
