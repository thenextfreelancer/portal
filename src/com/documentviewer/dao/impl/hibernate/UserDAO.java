package com.documentviewer.dao.impl.hibernate;

import java.io.Serializable;

import com.documentviewer.dao.DAO;
import com.documentviewer.entity.impl.User;

public interface UserDAO<T extends User, PK extends Serializable> extends DAO<T, PK> {

	public User findUserByEmail(String emailId) throws Exception;
	
	public User findUserByUserName(String userName) throws Exception;
	
}
