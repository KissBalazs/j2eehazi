package hu.forest.jeehazi.dao;
import hu.forest.jeehazi.model.BaseEntity;
import hu.forest.jeehazi.model.Car;
import hu.forest.jeehazi.model.Rent;
import hu.forest.jeehazi.model.User;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 *     Segítségével meghívjuk az EntityManager-t, és egyszerűbb műveleteket hajtunk végre az adatbázis és
 *     az alkalmazás modellje között: mentés, törlés, keresés, stb.
 */

@Stateless
@LocalBean
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
        // az entitást "rá kell kötni" az adatbázisban található párjára mielőtt töröljük..
        selectedEntity = entityManager.getReference(selectedEntity.getClass(), selectedEntity.getId());

        entityManager.remove(selectedEntity);
    }

    public User findUser(String name){
        return (User) entityManager.createQuery("select u from User u where u.name =:name")
                .setParameter("name", name)
                .getResultList()
                .get(0);
    }

}