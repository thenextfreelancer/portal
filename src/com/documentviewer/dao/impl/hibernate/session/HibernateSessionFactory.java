package com.documentviewer.dao.impl.hibernate.session;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.documentviewer.config.PathConfig;
import com.documentviewer.util.ReflectionUtils;

public class HibernateSessionFactory {

	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static final Configuration config = new Configuration();
	private static SessionFactory sessionFactory = null;

	static {
		try {
			sessionFactory = buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Error in creating hibernate session factory :: " + e.getMessage());
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	private static SessionFactory buildSessionFactory() throws HibernateException, Exception {
		Set<Class<?>> entityAnnotatedClasses = ReflectionUtils.getJPAEntityAnnotatedClasses();
		entityAnnotatedClasses = new HashSet<Class<?>>(entityAnnotatedClasses);
		for (Class<?> annotatedClass : entityAnnotatedClasses) {
			config.addAnnotatedClass(annotatedClass);
		}
		return config.configure(new File(PathConfig.getHibernateConfigPath())).buildSessionFactory();
	}

	/**
	 * Returns the ThreadLocal Session instance. Lazy initialize the
	 * <code>SessionFactory</code> if needed.
	 * 
	 * @return Session
	 * @throws HibernateException
	 */
	public static Session getSession() throws HibernateException, Exception {
		Session session = (Session) threadLocal.get();

		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession() : null;
			threadLocal.set(session);
		}

		return session;
	}

	/**
	 * Rebuild hibernate session factory
	 * 
	 */
	static void rebuildSessionFactory() throws HibernateException, Exception {
		sessionFactory = buildSessionFactory();
	}

	/**
	 * Close the single hibernate session instance.
	 * 
	 * @throws HibernateException
	 */
	public static void closeSession() throws HibernateException {
		Session session = (Session) threadLocal.get();
		threadLocal.set(null);
		if (session != null) {
			session.close();
		}
	}

	/**
	 * return session factory
	 * 
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
