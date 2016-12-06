package hu.forest.jeehazi.model;

import lombok.Data;
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

// @Data annotáció: automatikusan generálja a setter, és getter metódusokat.
@Data
@EqualsAndHashCode
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Version
    private Long version;

    public BaseEntity() {
        id = UUID.randomUUID().toString();
    }

}
