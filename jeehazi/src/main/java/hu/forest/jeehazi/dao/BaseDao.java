package hu.forest.jeehazi.dao;
import hu.forest.jeehazi.model.BaseEntity;
import hu.forest.jeehazi.model.Car;
import hu.forest.jeehazi.model.Rent;
import hu.forest.jeehazi.model.User;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */

@Stateless
public class BaseDao {

    @PersistenceContext
    private EntityManager entityManager;

    public <E extends BaseEntity> List<E> query(Class<E> entityClass, String queryName) {
        return entityManager.createNamedQuery(queryName, entityClass).getResultList();
    }

    public <E extends BaseEntity> E save(E entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }

    public void delete(BaseEntity selectedEntity) {
        // kapok egy csonkot
        selectedEntity = entityManager.getReference(selectedEntity.getClass(), selectedEntity.getId());

        entityManager.remove(selectedEntity);
    }

    public void saveRent(Rent rentEntity, User userEntity, Car carEntity){ // todo: delete
        // todo: igen, saját dao kéne, de egy fgv...
//        userEntity = entityManager.getReference(userEntity.getClass(), userEntity.getId());
//        carEntity = entityManager.getReference(carEntity.getClass(), carEntity.getId());
        rentEntity.setUser(userEntity);
        rentEntity.setCar(carEntity);

        save(rentEntity);
    }

}