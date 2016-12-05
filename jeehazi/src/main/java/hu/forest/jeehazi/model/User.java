package hu.forest.jeehazi.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */

@NamedQueries(
        @NamedQuery(name = User.NQ_FIND_ALL_USERS, query = "select u from User u")
)
@Data
@Entity
@EqualsAndHashCode(callSuper = false, exclude = {"rents"})
@ToString(exclude = {"rents"})
public class User extends BaseEntity {

    public static final String NQ_FIND_ALL_USERS = "user.findAll";

    public User(){
        this.rents = new ArrayList<Rent>();
    }

    @Basic
    private String name;

    @Basic
    private String passwordHash;

    @Basic
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Rent> rents;

    // todo:
//    -request filter;
//    - session scope user;
}
