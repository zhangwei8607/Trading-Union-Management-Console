package com.it.tu.DAO.Hibernate;

import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.tu.beans.Enterprise;
import com.it.tu.beans.EnterpriseQuery;
import com.it.tu.DAO.EnterpriseDao;

public class HibernateEnterpriseDao_Gen implements EnterpriseDao{

	private SessionFactory sessionFactory;
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(Enterprise _enterprise)
	{
		getCurrentSession().save(_enterprise);
	}
	@Override
	public void update(Enterprise _enterprise) 
	{
		Enterprise _enterprise1 = findById(_enterprise.getId());
		_enterprise1.setDescription(_enterprise.getDescription());
		_enterprise1.setName(_enterprise.getName());
		_enterprise1.setProvince(_enterprise.getProvince());
		_enterprise1.setEmail(_enterprise.getEmail());
		_enterprise1.setPhone(_enterprise.getPhone());
		_enterprise1.setStatus(_enterprise.getStatus());
		_enterprise1.setFax(_enterprise.getFax());
		_enterprise1.setCity(_enterprise.getCity());
		_enterprise1.setContactUser(_enterprise.getContactUser());
		_enterprise1.setZipCode(_enterprise.getZipCode());
		_enterprise1.setMobile(_enterprise.getMobile());
		_enterprise1.setRegDate(_enterprise.getRegDate());
		_enterprise1.setCountry(_enterprise.getCountry());
		_enterprise1.setAddress(_enterprise.getAddress());
		getCurrentSession().update(_enterprise1);
	}
	@Override
	public void delete(Integer id) {
		Enterprise _enterprise=findById(id);
		if (_enterprise != null)
			getCurrentSession().delete(_enterprise);
	}

	@Override
	public Enterprise findById(Integer id)
	{
		Enterprise _enterprise=(Enterprise)getCurrentSession().get(Enterprise.class, id);
		return _enterprise;
	}
	
	@Override
	public List<Enterprise> findByQuery(EnterpriseQuery q) 
	{
		Criteria criteria = q.GetQuery(getCurrentSession().createCriteria(Enterprise.class));
		return (List<Enterprise>)criteria.list();
	}
	@Override
	public List<Enterprise> findAll()
	{
		List<Enterprise> _enterprise = (List<Enterprise>)getCurrentSession().createQuery("from Enterprise>").list();
		return _enterprise;
	}
}