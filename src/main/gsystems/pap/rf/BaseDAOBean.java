package main.gsystems.pap.rf;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
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
//@TransactionManagement(TransactionManagementType.CONTAINER)
public abstract class BaseDAOBean<T, K extends Serializable> implements BaseDAO<T, K> {

	private EntityManagerFactory emf;

<<<<<<< HEAD
//	@PersistenceContext
=======
	@PersistenceContext
>>>>>>> branch 'master' of https://github.com/GSystems/PAP.git
	private EntityManager entityManager;

	public static final Logger LOGGER = Logger.getLogger(BaseDAOBean.class.getName());

//	@PostConstruct
//	public void init() {
//		emf = Persistence.createEntityManagerFactory(GeneralConstants.SCHEMA);
//		emf.createEntityManager();
//	}

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
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public T insert(T t) {
		emf = Persistence.createEntityManagerFactory(GeneralConstants.SCHEMA);
		entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.getTransaction().commit();
		entityManager.close();
		emf.close();
		return t;
	}

	@Override
	public void delete(K id) {
		entityManager.remove(entityManager.getReference(type, id));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public T update(T t) {
		emf = Persistence.createEntityManagerFactory(GeneralConstants.SCHEMA);
		entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(t);
		entityManager.getTransaction().commit();
		entityManager.close();
		emf.close();
		return t;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public T findById(K id) {
		return entityManager.find(type, id);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<T> findAll() {
		emf = Persistence.createEntityManagerFactory(GeneralConstants.SCHEMA);
		entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		TypedQuery<T> query = entityManager.createQuery("from " + type.getName(), type);
		List<T> results = query.getResultList();
		entityManager.close();
		emf.close();
		return results;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void flush() {
		entityManager.flush();
	}
}
