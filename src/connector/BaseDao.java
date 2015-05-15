package connector;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.Transaction;

import common.IDbObject;

/**
 * Note sur les suppression de warnings "unused" pour les Exception. Comme l'interface est
 * implémentée deux fois dans la chaine d'héritage et si la classe en bout de chaine veut effectivement lancer
 * l'exception, il ne faut pas qu'une classe de la chaine évince le throws. Donc même si on ne throw pas dans
 * BaseDao, il faut laisser la déclaration
 * 
 * @param <T>
 *            le type d'entit?persist?
 * @param <ID>
 *            le type de la cl?primaire
 */
public abstract class BaseDao<T, ID extends Serializable> implements GenericDao<T, ID> {

	private static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	private static final Logger log = Logger.getLogger(SimpleDbConnector.class);
	
	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(final Criterion... criterion)
			throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<T> l = null;
		try {
			if(session == null) {
		        session = sessionFactory.openSession();
			}
			session.beginTransaction();
			Criteria crit = session.createCriteria(persistentClass);
			for (Criterion c : criterion) {
				crit.add(c);
			}
			l = crit.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error(e.getMessage(), e);
		} 
		return l;
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(final int maxResults, final Criterion... criterion)
			throws Exception {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		StatelessSession session = sessionFactory.openStatelessSession();
		List<T> l = null;
		try {
			Criteria crit = session.createCriteria(persistentClass);
			if (maxResults > 0) {
				crit.setMaxResults(maxResults);
			}
			for (Criterion c : criterion) {
				crit.add(c);
			}
			l = crit.list();
		} catch (HibernateException e) {
			throw new Exception(e);
		} finally {
			// session.close();
		}
		return l;
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(final Criterion[] criterion, final Order[] order)
			throws Exception {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		StatelessSession session = sessionFactory.openStatelessSession();
		List<T> l = null;

		try {
			Criteria crit = session.createCriteria(persistentClass);
			// Prise en compte des critères
			for (Criterion c : criterion) {
				crit.add(c);
			}
			// Prise en compte des clauses sur l'ordre
			for (Order o : order) {
				crit.addOrder(o);
			}
			// Remontée des résultats
			l = crit.list();
		} catch (HibernateException e) {
			throw new Exception(e);
		} finally {
			// Ne rien faire
		}
		return l;
	}

	@Override
	@SuppressWarnings({ "unchecked" })
	public T findById(ID id) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		StatelessSession session = sessionFactory.openStatelessSession();
		return (T) session.get(persistentClass, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll(Transaction transaction) throws Exception {
		List<T> lst;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		StatelessSession session = sessionFactory.openStatelessSession();
		try {
			Criteria crit = session.createCriteria(persistentClass);
			lst = crit.list();
		} catch (HibernateException e) {
			throw new Exception(e);
		}
		return lst;
	}

	@Override
	public T persist(T entity) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		StatelessSession session = sessionFactory.openStatelessSession();
		session.insert(entity);
		return entity;
	}

	@Override
	public void remove(T entity) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		StatelessSession session = sessionFactory.openStatelessSession();
		session.delete(entity);
	}

	@Override
	public void update(T entity) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		StatelessSession session = sessionFactory.openStatelessSession();
		session.update(entity);
	}

	protected List<T> findByQuery(String queryString)
			throws Exception {
		return findByQuery(queryString, -1);
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByQuery(String queryString, int maxResults) throws Exception {
		List<T> lst;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		StatelessSession session = sessionFactory.openStatelessSession();
		try {
			if (maxResults >= 0) {
				lst = session.createQuery(queryString).setMaxResults(
						maxResults).list();
			} else {
				lst = session.createQuery(queryString).list();
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return lst;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findById(String entityName, ID id, LockMode lockMode)
			throws Exception {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		StatelessSession session = sessionFactory.openStatelessSession();
		return (T) session.get(entityName, id, lockMode);
	}
}
