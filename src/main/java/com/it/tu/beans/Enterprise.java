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
@Table(name="ENT_Enterprise")
public class Enterprise
{
	
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Column(name="ID",nullable=false)
	private Integer id;
	
	@Column(name="Name",nullable=false)
	private String name;
	
	@Column(name="Country",nullable=false)
	private String country;
	
	@Column(name="Province",nullable=false)
	private String province;
	
	@Column(name="City",nullable=false)
	private String city;
	
	@Column(name="Address",nullable=false)
	private String address;
	
	@Column(name="ContactUser",nullable=false)
	private String contactUser;
	
	@Column(name="Phone",nullable=false)
	private String phone;
	
	@Column(name="Mobile")
	private String mobile;
	
	@Column(name="Fax")
	private String fax;
	
	@Column(name="Email",nullable=false)
	private String email;
	
	@Column(name="ZipCode")
	private String zipCode;
	
	@Column(name="Description",nullable=false)
	private String description;
	
	@Column(name="RegDate",nullable=false)
	private Date regDate;
	
	@Column(name="Status",nullable=false)
	private Integer status;
	
	public Enterprise(){
		
	}
	
	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getCountry()
	{
		return this.country;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	public String getProvince()
	{
		return this.province;
	}
	public void setProvince(String province)
	{
		this.province = province;
	}
	public String getCity()
	{
		return this.city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getAddress()
	{
		return this.address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getContactUser()
	{
		return this.contactUser;
	}
	public void setContactUser(String contactUser)
	{
		this.contactUser = contactUser;
	}
	public String getPhone()
	{
		return this.phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getMobile()
	{
		return this.mobile;
	}
	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	public String getFax()
	{
		return this.fax;
	}
	public void setFax(String fax)
	{
		this.fax = fax;
	}
	public String getEmail()
	{
		return this.email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getZipCode()
	{
		return this.zipCode;
	}
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public Date getRegDate()
	{
		return this.regDate;
	}
	public void setRegDate(Date regDate)
	{
		this.regDate = regDate;
	}
	public Integer getStatus()
	{
		return this.status;
	}
	public void setStatus(Integer status)
	{
		this.status = status;
	}
	

	
}


