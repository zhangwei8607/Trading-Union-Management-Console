package com.it.tu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.it.tu.DAO.EnterpriseRegisterDao;
import com.it.tu.beans.EnterpriseRegister;
import com.it.tu.beans.EnterpriseRegisterQuery;

@Transactional
public class EnterpriseRegisterService_Gen {
	
	@Autowired
	private EnterpriseRegisterDao repository;

	public void setEnterpriseRegisterDao(EnterpriseRegisterDao repository) {
		this.repository = repository;
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void create(EnterpriseRegister _enterpriseregister)
	{
		repository.create(_enterpriseregister);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void update(EnterpriseRegister _enterpriseregister)
	{
		repository.update(_enterpriseregister);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void delete(Integer id)
	{
		repository.delete(id);
	}
	@Transactional(readOnly=true)
	public EnterpriseRegister findById(Integer id)
	{
		return repository.findById(id);
	}
	@Transactional(readOnly=true)
	public List<EnterpriseRegister> findByQuery(EnterpriseRegisterQuery q)
	{
		return repository.findByQuery(q);
	}
}