package hu.forest.jeehazi.model;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */
public interface IBaseEntity {

    String getId();

    Long getVersion();

    void setId(String id);

    void setVersion(Long version);

}
