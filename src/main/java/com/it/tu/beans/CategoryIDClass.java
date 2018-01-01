package com.it.tu.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Embeddable
public class CategoryIDClass implements Serializable {

	private int categoryId;
	private int id;
	
	public CategoryIDClass(){}
	public CategoryIDClass(int categoryid,int id)
	{
		this.categoryId = categoryid;
		this.id = id;
	}
	public int getCategoryId(){
		return categoryId;
	}
	public void setCategoryId(int categoryId)
	{
		this.categoryId = categoryId;
	}
	
	public int getId()
	{
		return this.id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	@Override 
	public boolean equals(Object obj)
	{
		if(!(obj instanceof CategoryIDClass)) 
			return false;
		CategoryIDClass o = (CategoryIDClass)obj;
		return this.id==o.getId() && this.categoryId == o.getCategoryId();
	}
	
}
