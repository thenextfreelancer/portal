package com.documentviewer.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.documentviewer.entity.AbstractEntity;

@Table(name = "jp_usrentity")
@Entity
public class User extends AbstractEntity {

	private static final long serialVersionUID = -2638000448583329147L;

	@Id
	@Column(name = "jpf_id_p", nullable = false, updatable = false)
	private long id;
	
	@Column(name = "jpf_usrname", length = 48, nullable = false)
	@NotNull
	private String userName;

	@Column(name = "jpf_usrfname", length = 48, nullable = false)
	@NotNull
	private String firstName;

	@Column(name = "jpf_usrlname", length = 48, nullable = false)
	@NotNull
	private String lastName;

	@Column(name = "jpf_usrcrspndce_email", length = 48, nullable = false)
	@NotNull
	private String email;
	
	@Column(name = "jpf_usrpasskey", length = 48, nullable = false)
	@NotNull
	private String password;
	
	@Column(name = "jpf_date_creation", length = 48, nullable = false)
	@NotNull
	private String creationDate;
	
	@Column(name = "jpf_date_modified", length = 48, nullable = false)
	@NotNull
	private String modifiedDate;

	@Column(name = "jpf_state", length = 48, nullable = false)
	@NotNull
	private String state;

//	@ManyToOne(fetch=FetchType.EAGER, targetEntity=Role.class)
//	@JoinColumn(name="jpf_usrtype_id", updatable=false, insertable=false)
//	private Role roleAttrib;
	
	@Column(name = "jpf_usrtype_id", length = 48, nullable = false)
	@NotNull
	private long role;

	public transient String authorizationToken;

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getRole() {
		return role;
	}

	public void setRole(long role) {
		this.role = role;
	}

	public String getAuthorizationToken() {
		return authorizationToken;
	}

	public void setAuthorizationToken(String authorizationToken) {
		this.authorizationToken = authorizationToken;
	}
	
	
//	public Role getRoleAttrib() {
//		return roleAttrib;
//	}
//
//	public void setRoleAttrib(Role roleAttrib) {
//		this.roleAttrib = roleAttrib;
//	}

	public User(String firstName, String userName, String lastName, String email, String password, String creationDate, String modifiedDate, String state, int role){
		this.firstName=firstName;
		this.userName=userName;
		this.lastName=lastName;
		this.email=email;
		this.password=password;
		this.creationDate=creationDate;
		this.modifiedDate=modifiedDate;
		this.state=state;
		this.role = role;
	}
	
	public User(){
		
	}

}