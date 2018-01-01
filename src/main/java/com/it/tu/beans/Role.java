/**
 * 
 */
package com.it.tu.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "URP_Role")
public class Role implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name="Name",nullable=false)
	private String roleName;
	@Column(name="Description")
	private String description;
	@Column(name="Type",nullable=false)
	private Integer type;
	
	public Role() {
	}
	
	public Role(String roleName,String description,Integer type) {
		this.roleName = roleName;
		this.description=description;
		this.type=type;
	}
	public Role(Integer id, String roleName,String description,Integer type) {
		this.id = id;
		this.roleName = roleName;
		this.description=description;
		this.type=type;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String description)
	{
		this.description=description;
	}
	
	public Integer getType()
	{
		return this.type;
	}
	public void setType(Integer type)
	{
		this.type=type;
	}
}
