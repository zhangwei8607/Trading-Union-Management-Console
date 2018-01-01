package com.it.tu.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;


@Entity
@Table(name="DIC_Category")
public class Category {
	@Id 
	@Column(nullable=false)
	private int id;
	private String cd;
	private String name;
	private String ename;
	private String description;
	private String module;
	private String application;
	
	public int getId()	{		return this.id;	}
	public void setId(int id)	{		this.id=id;	}
	
	public String getCd()	{		return this.cd;	}
	public void setCd(String cd)	{		this.cd=cd;	}
	
	public String getName()	{	return this.name;	}
	public void setName(String name) {	this.name=name;	}
	
	public String getEname()	{	return this.ename;	}
	public void setEname(String ename)	{	this.ename=ename;	}
	
	public String getDescription()	{ return this.description;	}
	public void setDescription(String descripiton)	{	this.description=descripiton;	}
	
	public String getModule()	{	return this.module;	}
	public void setModule(String module)	{	this.module = module;	}
	
	public String getApplication()	{	return this.application;	}
	public void setApplication(String application)	{	this.application=application;	}
	
}
