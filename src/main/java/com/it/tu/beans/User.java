/**
 * 
 */
package com.it.tu.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="URP_User")
public class User 
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	@Column(nullable=false, unique=true)
	private String email;
	@Column(nullable=false)
	private String password;
	private Date regDate;
	private int status;
	private int type;
	@Column(name="UserRole_UserID")
	private int roleId;
//	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//	@JoinColumn(name="user_id")
//	private Set<Role> roles = new HashSet<Role>();
	
	public User() {
	}

	public User(int id, String name, String email, String password, Date regDate,int status,int type,int roleId) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.regDate = regDate;
		this.status=status;
		this.type=type;
		this.roleId=roleId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email
				+ ", regDate=" + regDate + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getRegDate() {
		return this.regDate;
	}

	public void setDob(Date regDate) {
		this.regDate = regDate;
	}
	public int getStatus()
	{
		return this.status;
	}
	public void setStatus(int status)
	{
		this.status=status;
	}
	public int getType()
	{
		return this.type;
	}
	public void setType(int type)
	{
		this.type=type;
	}
	public int getRoleId()
	{
		return this.roleId;
	}
	public void setRoleId(int roleId)
	{
		this.roleId=roleId;
	}
	
//	public Set<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}
	
}
