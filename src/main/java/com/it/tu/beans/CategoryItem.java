package com.it.tu.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DIC_Item")
public class CategoryItem {

	
	@Id
	private CategoryIDClass key;
	@Column(name="cd")
	private String cd;
	private String name;
	private String ename;
	private String description;
	private int showorder;
	private boolean status;
	
	
	public CategoryItem(){
		key=new CategoryIDClass();
	}
	
	public CategoryItem(int id,int categoryid,String cd,String name,String ename,String description,
			int showorder,boolean status){
		key=new CategoryIDClass();
		this.key.setId(id);
		this.key.setCategoryId(categoryid);
		this.cd=cd;
		this.name=name;
		this.ename=ename;
		this.description=description;
		this.showorder=showorder;
		this.status=status;
	}
	
	public CategoryIDClass getkey()
	{
		return this.key;
	}
	
	public void setId(CategoryIDClass key)
	{
		this.key=key;
	}
	
	public String getCd()
	{
		return this.cd;
	}
	public void setCd(String cd)
	{
		this.cd=cd;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getEname()
	{
		return this.ename;
	}
	public void setEname(String ename)
	{
		this.ename=ename;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String description)
	{
		this.description=description;
	}
	public int getShoworder()
	{
		return this.showorder;
	}
	public void setShoworder(int showorder)
	{
		this.showorder=showorder;
	}
	public boolean getStatus()
	{
		return this.status;
	}
	public void setStatus(boolean status)
	{
		this.status=status;
	}
}
