package main.java.pap.rf;

import java.io.Serializable;

/**
 * The base DAO bean that must be extended by all DAOs.
 * 
 * @param <T> the specific entity type
 * @param <K> the specific entity primary key type
 */
public interface PersistenceDAO<T, K extends Serializable> {

	/**
	 * Insert a new object.
	 *
	 * @param t
	 *            the object to insert
	 * @return the inserted object
	 */
	public T insert(T t);

}
