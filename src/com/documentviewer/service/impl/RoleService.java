/**
 * 
 */
package com.documentviewer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.documentviewer.dao.impl.hibernate.impl.RoleDAOImpl;
import com.documentviewer.entity.impl.Role;
import com.documentviewer.service.Service;

/**
 * @author Arpit
 *
 */
public class RoleService  implements Service<Role, Long>{
	
	@Autowired
	RoleDAOImpl<Role, Long> roleDAOImpl;

	public Role findRoleById(Long roleId) throws Exception {
		return roleDAOImpl.readEntity(roleId);
	}

}
