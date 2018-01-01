package com.it.tu.beans;

import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
public class EnterpriseQuery 
{
	
	private Integer id;

	private String name;

	private String country;

	private String province;

	private String city;

	private String address;

	private String contactUser;

	private String phone;

	private String mobile;

	private String fax;

	private String email;

	private String zipCode;

	private String description;

	private Date regDateStart;

	private Date regDateEnd;

	private Integer status;
	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer id)
	{
		this.id=id;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getCountry()
	{
		return this.country;
	}
	public void setCountry(String country)
	{
		this.country=country;
	}
	public String getProvince()
	{
		return this.province;
	}
	public void setProvince(String province)
	{
		this.province=province;
	}
	public String getCity()
	{
		return this.city;
	}
	public void setCity(String city)
	{
		this.city=city;
	}
	public String getAddress()
	{
		return this.address;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public String getContactUser()
	{
		return this.contactUser;
	}
	public void setContactUser(String contactUser)
	{
		this.contactUser=contactUser;
	}
	public String getPhone()
	{
		return this.phone;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	public String getMobile()
	{
		return this.mobile;
	}
	public void setMobile(String mobile)
	{
		this.mobile=mobile;
	}
	public String getFax()
	{
		return this.fax;
	}
	public void setFax(String fax)
	{
		this.fax=fax;
	}
	public String getEmail()
	{
		return this.email;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getZipCode()
	{
		return this.zipCode;
	}
	public void setZipCode(String zipCode)
	{
		this.zipCode=zipCode;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String description)
	{
		this.description=description;
	}
	public Date getRegDateStart()
	{
		return this.regDateStart;
	}
	public void setRegDateStart(Date regDate)
	{
		this.regDateStart=regDateStart;
	}
	public Date getRegDateEnd()
	{
		return this.regDateEnd;
	}
	public void setRegDateEnd(Date regDate)
	{
		this.regDateEnd=regDateEnd;
	}
	public Integer getStatus()
	{
		return this.status;
	}
	public void setStatus(Integer status)
	{
		this.status=status;
	}


	public Criteria GetQuery(Criteria q) 
	{
		if(this.id != null)
		{
			q.add(Restrictions.eq("id",id));
		}
		if(name != null && !"".equals(name))
		{
			q.add(Restrictions.like("name","%"+name+"%"));
		}
		if(country != null && !"".equals(country))
		{
			q.add(Restrictions.eq("country",country));
		}
		if(province != null && !"".equals(province))
		{
			q.add(Restrictions.eq("province",province));
		}
		if(city != null && !"".equals(city))
		{
			q.add(Restrictions.eq("city",city));
		}
		if(address != null && !"".equals(address))
		{
			q.add(Restrictions.eq("address",address));
		}
		if(contactUser != null && !"".equals(contactUser))
		{
			q.add(Restrictions.like("contactUser","%"+contactUser+"%"));
		}
		if(phone != null && !"".equals(phone))
		{
			q.add(Restrictions.eq("phone",phone));
		}
		if(mobile != null && !"".equals(mobile))
		{
			q.add(Restrictions.eq("mobile",mobile));
		}
		if(fax != null && !"".equals(fax))
		{
			q.add(Restrictions.eq("fax",fax));
		}
		if(email != null && !"".equals(email))
		{
			q.add(Restrictions.eq("email",email));
		}
		if(zipCode != null && !"".equals(zipCode))
		{
			q.add(Restrictions.eq("zipCode",zipCode));
		}
		if(description != null && !"".equals(description))
		{
			q.add(Restrictions.eq("description",description));
		}
		if(this.regDateStart != null)
		{
			q.add(Restrictions.ge("regDate",regDateStart));
		}
		if(this.regDateEnd != null)
		{
			q.add(Restrictions.le("regDate",regDateEnd));
		}
		if(this.status != null)
		{
			q.add(Restrictions.eq("status",status));
		}

		return q;
	}
}