package com.documentviewer.dao.impl.hibernate.impl;

import java.io.Serializable;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.documentviewer.dao.impl.hibernate.UserDAO;
import com.documentviewer.dao.impl.hibernate.session.HibernateSessionFactory;
import com.documentviewer.entity.impl.User;

@Repository
public class UserDAOImpl<T extends User, PK extends Serializable> extends HibernateDAOImpl<T, PK>
		implements UserDAO<T, PK> {

	@SuppressWarnings("unchecked")
	@Override
	public User findUserByEmail(String emailId) throws Exception {
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			T entity = (T) session.createCriteria(getPersistentClass()).add(Restrictions.eq("email", emailId))
					.uniqueResult();
			tx.commit();
			return entity;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public UserDAOImpl() {
		setPersistentClass((Class<T>) User.class);
	}

	public User findUserByUserName(String userName) throws Exception {
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			User entity = (User) session.createCriteria(getPersistentClass()).add(Restrictions.eq("userName", userName))
					.uniqueResult();
			return entity;
		} catch (Exception e) {
			throw e;
		}
	}
}
