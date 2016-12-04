package hu.forest.jeehazi.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */
@EqualsAndHashCode
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
//    @Getter
//    @Setter
    @Column(name = "id")
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @Version
    @Getter
    @Setter
    private Long version;

    public BaseEntity() {
        id = UUID.randomUUID().toString();
    }

}
