/**
 * 
 */
package com.documentviewer.dao.impl.hibernate.impl;

import java.io.Serializable;

import com.documentviewer.dao.impl.hibernate.RoleDAO;
import com.documentviewer.entity.impl.Role;

/**
 * @author Arpit
 *
 */
public class RoleDAOImpl<T extends Role, PK extends Serializable> extends HibernateDAOImpl<T, PK>
implements RoleDAO<T, PK> {

}
