package com.documentviewer.entity.impl;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.documentviewer.entity.Entity;

@Table(name = "jp_roles")
@javax.persistence.Entity
public class Role implements Entity {

	public static final String ADMIN_ROLE = "ADMIN";
	
	public static final String CONSULTANT_ROLE = "CONSULTANT";
	
	public static final String COMPANY_ROLE = "COMPANY";
	
	public static final String TALENT_ROLE = "TALENT";

	private static final long serialVersionUID = -3297450209354341838L;

	@Id
	@Column(name = "jpf_id_p", nullable = false, updatable=false, insertable=false)
	private long id;
	
	@Column(name = "jpf_role_name", length = 48, nullable = false, updatable=false, insertable=false)
	@NotNull
	private String roleName;

	@Column(name = "jpf_role_code", length = 48, nullable = false, updatable=false, insertable=false)
	@NotNull
	private String roleCode;

	@Column(name = "jpf_role_desc", length = 48, nullable = false, updatable=false, insertable=false)
	private String roleDesc;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

}
