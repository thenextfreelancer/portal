package com.documentviewer.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.documentviewer.entity.Entity;

public interface DAO<T extends Entity, PK extends Serializable> {

	void setPersistentClass(Class<T> persistentClass);

	Class<T> getPersistentClass();

	PK createEntity(T newInstance) throws Exception;

	void createEntities(List<T> entities) throws Exception;

	T readEntity(PK id) throws Exception;

	Set<T> readALLEntities() throws Exception;

	void updateEntity(T transientObject) throws Exception;

	void deleteEntity(T persistentObject) throws Exception;

	void saveOrUpdateEntity(T instance) throws Exception;

	void saveOrUpdateEntities(List<T> entities) throws Exception;

}
