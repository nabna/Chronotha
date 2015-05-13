package connector;

import java.io.Serializable;
import java.util.List;

import org.hibernate.LockMode;

import org.hibernate.Transaction;

public interface GenericDao<T, ID extends Serializable> {

	T findById(ID id) throws Exception;

	T findById(String entityName, ID id, LockMode lockMode)
			throws Exception;

	List<T> findAll(Transaction transaction) throws Exception;

	T persist(T entity) throws Exception;

	void remove(T entity) throws Exception;

	void update(T entity) throws Exception;
}
