package epam.com.DAO;

import epam.com.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrey_Bindyuk on 7/15/2014.
 */
public abstract class AbstractDAO<T, PK extends Serializable> {
    private Class<T> entityClass;

    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    public AbstractDAO(Class<T> entityTClass) {
        this.entityClass = entityTClass;
    }

    public AbstractDAO() {
    }

    public EntityManager getEm() {
        return em;
    }

    public void create(T entity) {
        getEm().merge(entity);
    }

    public List<T> findByNamedQuery(String queryName,
                                    Map<String, Object> attributes) {
        Query query = em.createNamedQuery(queryName, entityClass);
        for (String s : attributes.keySet()) {
            query.setParameter(s, attributes.get(s));
        }
        return query.getResultList();
    }

    public void edit(T entity) {
        em.merge(entity);
    }

    public void remove(T entity) {
        em.remove(em.merge(entity));
    }

    public T find(PK id) {
        return em.find(entityClass, id);
    }

    public List<T> findAll() {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEm().createQuery(cq).getResultList();
    }
}
