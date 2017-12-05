package main.java.pap.rf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistenceService {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PAP");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static <T> void persist(T obj) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(obj);
		et.commit();
		em.close();
	}
}
