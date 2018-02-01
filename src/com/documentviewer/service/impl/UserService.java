package com.documentviewer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.documentviewer.dao.impl.hibernate.impl.UserDAOImpl;
import com.documentviewer.entity.impl.User;
import com.documentviewer.service.Service;
import com.documentviewer.util.ExceptionUtil;

@org.springframework.stereotype.Service
public class UserService implements Service<User, Long> {

	@Autowired
	UserDAOImpl<User, Long> userDAOImpl;

	public User findUserByEmail(String emailId) throws Exception {
		return userDAOImpl.findUserByEmail(emailId);
	}
	
	public User findUserByUserName(String userName) throws Exception {
		return userDAOImpl.findUserByUserName(userName);
	}

	public Long createEntity(User user) throws Exception {
		return userDAOImpl.createEntity(user);
	}
//	public User getEntity(Long id) throws Exception {
//		
//		userDAOImpl.readEntity(id);
//		//user.setId(id);
//		return user;
//	}
}
