package com.documentviewer.dao.impl.hibernate.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.documentviewer.dao.DAO;
import com.documentviewer.entity.Entity;

@Repository
public class HibernateDAOImpl<T extends Entity, PK extends Serializable> implements DAO<T, PK> {

	Class<T> persistentClass;

	@Override
	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@Override
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@Autowired
	@Qualifier("hibernateSession")
	Session session;

	@SuppressWarnings("unchecked")
	@Override
	public PK createEntity(T newInstance) throws Exception {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			PK key = (PK) session.save(newInstance);
			tx.commit();
			return key;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
	}

	@Override
	public T readEntity(PK id) throws Exception {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			T entity = (T) session.get(getPersistentClass(), id);
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
	@Override
	public Set<T> readALLEntities() throws Exception {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<T> entityList = (List<T>) session.createCriteria(getPersistentClass()).list();
			tx.commit();
			return new HashSet<T>(entityList);
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
	}

	@Override
	public void updateEntity(T transientObject) throws Exception {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(transientObject);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
	}

	@Override
	public void deleteEntity(T persistentObject) throws Exception {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(persistentObject);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
	}

	@Override
	public void saveOrUpdateEntity(T instance) throws Exception {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(instance);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
	}

	@Override
	public void createEntities(List<T> entities) throws Exception {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			for (T t : entities) {
				session.save(t);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}

	}

	@Override
	public void saveOrUpdateEntities(List<T> entities) throws Exception {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			for (T t : entities) {
				session.saveOrUpdate(t);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}

	}

}
