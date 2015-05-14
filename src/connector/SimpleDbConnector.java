package connector;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import common.IDbObject;

public class SimpleDbConnector {
	
	private static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	private static final Logger log = Logger.getLogger(SimpleDbConnector.class);
	
	public static void save(IDbObject dbObject) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(dbObject);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error(e.getMessage(), e);
			session.getTransaction().rollback();
		}
	}
	
	public static void update(IDbObject dbObject) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.update(dbObject);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error(e.getMessage(), e);
			session.getTransaction().rollback();
		}
	}
	
	public static void delete(IDbObject dbObject) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.delete(dbObject);
			session.getTransaction().commit();
			
		} catch (HibernateException e) {
			log.error(e.getMessage(), e);
			session.getTransaction().rollback();
		}
		
	}
	
	public static IDbObject get(Class<?> clazz, int id) {
		Session session = sessionFactory.getCurrentSession();
		IDbObject dbObject = null;
		try {
			if(session == null) {
		        session = sessionFactory.openSession();
			}
			session.beginTransaction();
			dbObject = (IDbObject)session.load(clazz, id);
			Hibernate.initialize(dbObject);
			session.getTransaction().commit();
			return dbObject;
		} catch (HibernateException e) {
			log.error(e.getMessage(), e);
		}
		return dbObject;
	}
	
	@SuppressWarnings("unchecked")
	public static List<IDbObject> getAll(Class<?> clazz) {
		Session session = sessionFactory.getCurrentSession();
		List<IDbObject> list = null;
		try {
			if(session == null) {
		        session = sessionFactory.openSession();
			}
			session.beginTransaction();
			Query query = session.createQuery("from " + clazz.getName());
	        list = (List<IDbObject>) query.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error(e.getMessage(), e);
		}
		return list;
	}
	
}
