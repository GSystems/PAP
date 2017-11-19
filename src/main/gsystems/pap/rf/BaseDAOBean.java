package main.gsystems.pap.rf;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.gsystems.pap.util.GeneralConstants;

/**
 * The base DAO bean that must be extended by all DAOs.
 * @param <T> the specific entity type
 * @param <K> the specific entity primary key type
 */
public abstract class BaseDAOBean<T, K extends Serializable> implements BaseDAO<T, K> {

	private EntityManagerFactory emf;
	private EntityManager entityManager;
	private Class<T> type;
	
	@PostConstruct
	public void init() {
		emf = Persistence.createEntityManagerFactory(GeneralConstants.SCHEMA);
		entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
	}

	@SuppressWarnings("unchecked")
	public BaseDAOBean() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<T>) pt.getActualTypeArguments()[0];
	}

	protected EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public T insert(T t) {
		entityManager.persist(t);
		entityManager.getTransaction().commit();
		return t;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void delete(K id) {
		entityManager.remove(entityManager.getReference(type, id));
		entityManager.getTransaction().commit();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public T update(T t) {
		entityManager.merge(t);
		entityManager.getTransaction().commit();
		return t;
	}

	@Override
	public T findById(K id) {
		return entityManager.find(type, id);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<T> findAll() {
		return entityManager.createQuery("from " + type.getName(), type).getResultList();
	}

	@Override
	public void flush() {
		entityManager.flush();
	}
}
