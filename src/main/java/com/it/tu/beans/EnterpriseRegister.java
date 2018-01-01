package com.it.tu.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ENT_EnterpriseRegister")
public class EnterpriseRegister
{
	
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Column(name="ID",nullable=false)
	private Integer id;
	
	@Column(name="EnterpriseID",nullable=false)
	private Integer enterpriseId;
	
	@Column(name="FullName",nullable=false)
	private String fullName;
	
	@Column(name="RegisterNo",nullable=false)
	private String registerNo;
	
	@Column(name="TaxNo",nullable=false)
	private String taxNo;
	
	@Column(name="OpenAccountNo",nullable=false)
	private String openAccountNo;
	
	@Column(name="RegisterAddress",nullable=false)
	private String registerAddress;
	
	@Column(name="CreateDate",nullable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	
	@Column(name="FailureDate",nullable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date failureDate;
	
	@Column(name="Scope",nullable=false)
	private String scope;
	
	@Column(name="BusinessEntity",nullable=false)
	private String businessEntity;
	
	@Column(name="EntityIDNo",nullable=false)
	private String entityIDNo;
	
	@Column(name="EntityIDType",nullable=false)
	private Integer entityIDType;
	
	@Column(name="Description")
	private String description;
	
	public EnterpriseRegister(){
		
	}
	
	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getEnterpriseId()
	{
		return this.enterpriseId;
	}
	public void setEnterpriseId(Integer enterpriseId)
	{
		this.enterpriseId = enterpriseId;
	}
	public String getFullName()
	{
		return this.fullName;
	}
	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}
	public String getRegisterNo()
	{
		return this.registerNo;
	}
	public void setRegisterNo(String registerNo)
	{
		this.registerNo = registerNo;
	}
	public String getTaxNo()
	{
		return this.taxNo;
	}
	public void setTaxNo(String taxNo)
	{
		this.taxNo = taxNo;
	}
	public String getOpenAccountNo()
	{
		return this.openAccountNo;
	}
	public void setOpenAccountNo(String openAccountNo)
	{
		this.openAccountNo = openAccountNo;
	}
	public String getRegisterAddress()
	{
		return this.registerAddress;
	}
	public void setRegisterAddress(String registerAddress)
	{
		this.registerAddress = registerAddress;
	}
	public Date getCreateDate()
	{
		return this.createDate;
	}
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
	public Date getFailureDate()
	{
		return this.failureDate;
	}
	public void setFailureDate(Date failureDate)
	{
		this.failureDate = failureDate;
	}
	public String getScope()
	{
		return this.scope;
	}
	public void setScope(String scope)
	{
		this.scope = scope;
	}
	public String getBusinessEntity()
	{
		return this.businessEntity;
	}
	public void setBusinessEntity(String businessEntity)
	{
		this.businessEntity = businessEntity;
	}
	public String getEntityIDNo()
	{
		return this.entityIDNo;
	}
	public void setEntityIDNo(String entityIDNo)
	{
		this.entityIDNo = entityIDNo;
	}
	public Integer getEntityIDType()
	{
		return this.entityIDType;
	}
	public void setEntityIDType(Integer entityIDType)
	{
		this.entityIDType = entityIDType;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	

	
}


