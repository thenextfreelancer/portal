package com.documentviewer.service;

import java.io.Serializable;
import java.util.List;

import com.documentviewer.entity.Entity;
import com.documentviewer.util.ExceptionUtil;

public interface Service<T extends Entity, PK extends Serializable> {

	public default PK createEntity(T entity) throws Exception {
		throw ExceptionUtil.methodNotSupportedException();
	}

	public default void updateEntity(T entity) throws Exception {
		throw ExceptionUtil.methodNotSupportedException();
	}

	public default List<T> getEntities() throws Exception {
		throw ExceptionUtil.methodNotSupportedException();
	}

	public default T getEntity(PK entityId) throws Exception {
		throw ExceptionUtil.methodNotSupportedException();
	}

	public default void deleteEntity(T entity) throws Exception {
		throw ExceptionUtil.methodNotSupportedException();
	}

}
