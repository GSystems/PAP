package main.java.pap.rf;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * The base DAO bean that must be extended by all DAOs.
 * 
 * @param <T> the specific entity type
 * @param <K> the specific entity primary key type
 */
public class PersistenceDAOBean<T, K extends Serializable> implements PersistenceDAO<T, K> {

	@PersistenceContext(unitName="practice")
	private EntityManager entityManager;
	private Class<T> type;

	@SuppressWarnings("unchecked")
	public PersistenceDAOBean() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<T>) pt.getActualTypeArguments()[0];
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public T insert(T t) {
		entityManager.persist(t);
		return t;
	}

}
