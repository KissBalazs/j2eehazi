package hu.forest.jeehazi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@MappedSuperclass
public class BaseEntity implements Serializable, IBaseEntity {

    @Id
    @Column(name = "id", length = 36, nullable = false)
    private String id = UUID.randomUUID().toString();

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

}

