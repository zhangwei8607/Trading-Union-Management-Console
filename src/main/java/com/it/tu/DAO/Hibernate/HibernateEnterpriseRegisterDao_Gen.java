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

import com.it.tu.beans.EnterpriseRegister;
import com.it.tu.beans.EnterpriseRegisterQuery;
import com.it.tu.DAO.EnterpriseRegisterDao;

public class HibernateEnterpriseRegisterDao_Gen implements EnterpriseRegisterDao{

	private SessionFactory sessionFactory;
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(EnterpriseRegister _enterpriseregister)
	{
		getCurrentSession().save(_enterpriseregister);
	}
	@Override
	public void update(EnterpriseRegister _enterpriseregister) 
	{
		EnterpriseRegister _enterpriseregister1 = findById(_enterpriseregister.getId());
		_enterpriseregister1.setFullName(_enterpriseregister.getFullName());
		_enterpriseregister1.setBusinessEntity(_enterpriseregister.getBusinessEntity());
		_enterpriseregister1.setEntityIDNo(_enterpriseregister.getEntityIDNo());
		_enterpriseregister1.setRegisterAddress(_enterpriseregister.getRegisterAddress());
		_enterpriseregister1.setDescription(_enterpriseregister.getDescription());
		_enterpriseregister1.setOpenAccountNo(_enterpriseregister.getOpenAccountNo());
		_enterpriseregister1.setEntityIDType(_enterpriseregister.getEntityIDType());
		_enterpriseregister1.setScope(_enterpriseregister.getScope());
		_enterpriseregister1.setTaxNo(_enterpriseregister.getTaxNo());
		_enterpriseregister1.setFailureDate(_enterpriseregister.getFailureDate());
		_enterpriseregister1.setRegisterNo(_enterpriseregister.getRegisterNo());
		_enterpriseregister1.setCreateDate(_enterpriseregister.getCreateDate());
		getCurrentSession().update(_enterpriseregister1);
	}
	@Override
	public void delete(Integer id) {
		EnterpriseRegister _enterpriseregister=findById(id);
		if (_enterpriseregister != null)
			getCurrentSession().delete(_enterpriseregister);
	}

	@Override
	public EnterpriseRegister findById(Integer id)
	{
		EnterpriseRegister _enterpriseregister=(EnterpriseRegister)getCurrentSession().get(EnterpriseRegister.class, id);
		return _enterpriseregister;
	}
	
	@Override
	public List<EnterpriseRegister> findByQuery(EnterpriseRegisterQuery q) 
	{
		Criteria criteria = q.GetQuery(getCurrentSession().createCriteria(EnterpriseRegister.class));
		return (List<EnterpriseRegister>)criteria.list();
	}
	@Override
	public List<EnterpriseRegister> findAll()
	{
		List<EnterpriseRegister> _enterpriseregister = (List<EnterpriseRegister>)getCurrentSession().createQuery("from EnterpriseRegister>").list();
		return _enterpriseregister;
	}
}