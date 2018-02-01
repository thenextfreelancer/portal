/**
 * 
 */
package com.documentviewer.dao.impl.hibernate;

import java.io.Serializable;

import com.documentviewer.dao.DAO;
import com.documentviewer.entity.impl.Role;

/**
 * @author Arpit
 *
 */
public interface RoleDAO<T extends Role, PK extends Serializable> extends DAO<T, PK> {

}
