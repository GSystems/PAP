package main.java.pap.rf;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * The base DAO bean that must be extended by all DAOs.
 * 
 * @param <T> the specific entity type
 * @param <K> the specific entity primary key type
 */
public abstract class BaseDAOBean<T, K extends Serializable> implements BaseDAO<T, K> {

	@PersistenceContext(unitName="PAP")
	private EntityManager entityManager;
	private Class<T> type;

	@SuppressWarnings("unchecked")
	public BaseDAOBean() {
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

	@Override
	public void delete(K id) {
		entityManager.remove(entityManager.getReference(type, id));
	}

	@Override
	public T update(T t) {
		entityManager.merge(t);
		return t;
	}

	@Override
	public T findById(K id) {
		return entityManager.find(type, id);
	}

	@Override
	public List<T> findAll() {
		return entityManager.createQuery("from " + type.getName(), type).getResultList();
	}

	@Override
	public void flush() {
		entityManager.flush();
	}

}
