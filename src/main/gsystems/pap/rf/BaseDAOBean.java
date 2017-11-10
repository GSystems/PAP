package main.gsystems.pap.rf;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import main.gsystems.pap.util.GeneralConstants;

/**
 * The base DAO bean that must be extended by all DAOs.
 * @param <T> the specific entity type
 * @param <K> the specific entity primary key type
 */
public abstract class BaseDAOBean<T, K extends Serializable> implements BaseDAO<T, K> {

	private EntityManagerFactory emf;

	@PersistenceContext
	private EntityManager entityManager;

	public static final Logger LOGGER = Logger.getLogger(BaseDAOBean.class.getName());

	@PostConstruct
	public void init() {
		emf = Persistence.createEntityManagerFactory(GeneralConstants.SCHEMA);
		emf.createEntityManager();
	}

	private Class<T> type;

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
		return entityManager.merge(t);
	}

	@Override
	public T findById(K id) {
		return entityManager.find(type, id);
	}

	@Override
	public List<T> findAll() {
		TypedQuery<T> query = entityManager.createQuery("from " + type.getName(), type);
		return query.getResultList();
	}

	@Override
	public void flush() {
		entityManager.flush();
	}
}
