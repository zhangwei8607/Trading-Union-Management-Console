package com.it.tu.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Isolation;

import com.it.tu.beans.Enterprise;
import com.it.tu.beans.EnterpriseQuery;
import com.it.tu.DAO.EnterpriseDao;

@Transactional
public class EnterpriseService_Gen {
	
	@Autowired
	private EnterpriseDao repository;

	public void setEnterpriseDao(EnterpriseDao repository) {
		this.repository = repository;
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void create(Enterprise _enterprise)
	{
		repository.create(_enterprise);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void update(Enterprise _enterprise)
	{
		repository.update(_enterprise);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void delete(Integer id)
	{
		repository.delete(id);
	}
	@Transactional(readOnly=true)
	public Enterprise findById(Integer id)
	{
		return repository.findById(id);
	}
	@Transactional(readOnly=true)
	public List<Enterprise> findByQuery(EnterpriseQuery q)
	{
		return repository.findByQuery(q);
	}
}