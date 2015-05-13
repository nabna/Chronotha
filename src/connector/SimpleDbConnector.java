package connector;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import common.IDbObject;

public class SimpleDbConnector {
	
	private static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public static void save(IDbObject dbObject) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(dbObject);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
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
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
	
}
