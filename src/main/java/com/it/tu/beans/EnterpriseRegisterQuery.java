package com.it.tu.beans;

import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
public class EnterpriseRegisterQuery 
{
	
	private String fullName;

	private String registerNo;

	private String taxNo;

	private String openAccountNo;

	private Date createDateStart;

	private Date createDateEnd;

	private Date failureDateStart;

	private Date failureDateEnd;

	private String businessEntity;

	private String entityIDNo;

	private Integer entityIDType;
	public String getFullName()
	{
		return this.fullName;
	}
	public void setFullName(String fullName)
	{
		this.fullName=fullName;
	}
	public String getRegisterNo()
	{
		return this.registerNo;
	}
	public void setRegisterNo(String registerNo)
	{
		this.registerNo=registerNo;
	}
	public String getTaxNo()
	{
		return this.taxNo;
	}
	public void setTaxNo(String taxNo)
	{
		this.taxNo=taxNo;
	}
	public String getOpenAccountNo()
	{
		return this.openAccountNo;
	}
	public void setOpenAccountNo(String openAccountNo)
	{
		this.openAccountNo=openAccountNo;
	}
	public Date getCreateDateStart()
	{
		return this.createDateStart;
	}
	public void setCreateDateStart(Date createDate)
	{
		this.createDateStart=createDateStart;
	}
	public Date getCreateDateEnd()
	{
		return this.createDateEnd;
	}
	public void setCreateDateEnd(Date createDate)
	{
		this.createDateEnd=createDateEnd;
	}
	public Date getFailureDateStart()
	{
		return this.failureDateStart;
	}
	public void setFailureDateStart(Date failureDate)
	{
		this.failureDateStart=failureDateStart;
	}
	public Date getFailureDateEnd()
	{
		return this.failureDateEnd;
	}
	public void setFailureDateEnd(Date failureDate)
	{
		this.failureDateEnd=failureDateEnd;
	}
	public String getBusinessEntity()
	{
		return this.businessEntity;
	}
	public void setBusinessEntity(String businessEntity)
	{
		this.businessEntity=businessEntity;
	}
	public String getEntityIDNo()
	{
		return this.entityIDNo;
	}
	public void setEntityIDNo(String entityIDNo)
	{
		this.entityIDNo=entityIDNo;
	}
	public Integer getEntityIDType()
	{
		return this.entityIDType;
	}
	public void setEntityIDType(Integer entityIDType)
	{
		this.entityIDType=entityIDType;
	}


	public Criteria GetQuery(Criteria q) 
	{
		if(fullName != null && !"".equals(fullName))
		{
			q.add(Restrictions.like("fullName","%"+fullName+"%"));
		}
		if(registerNo != null && !"".equals(registerNo))
		{
			q.add(Restrictions.like("registerNo","%"+registerNo+"%"));
		}
		if(taxNo != null && !"".equals(taxNo))
		{
			q.add(Restrictions.like("taxNo","%"+taxNo+"%"));
		}
		if(openAccountNo != null && !"".equals(openAccountNo))
		{
			q.add(Restrictions.like("openAccountNo","%"+openAccountNo+"%"));
		}
		if(this.createDateStart != null)
		{
			q.add(Restrictions.ge("createDate",createDateStart));
		}
		if(this.createDateEnd != null)
		{
			q.add(Restrictions.le("createDate",createDateEnd));
		}
		if(this.failureDateStart != null)
		{
			q.add(Restrictions.ge("failureDate",failureDateStart));
		}
		if(this.failureDateEnd != null)
		{
			q.add(Restrictions.le("failureDate",failureDateEnd));
		}
		if(businessEntity != null && !"".equals(businessEntity))
		{
			q.add(Restrictions.like("businessEntity","%"+businessEntity+"%"));
		}
		if(entityIDNo != null && !"".equals(entityIDNo))
		{
			q.add(Restrictions.eq("entityIDNo",entityIDNo));
		}
		if(this.entityIDType != null)
		{
			q.add(Restrictions.eq("entityIDType",entityIDType));
		}

		return q;
	}
}