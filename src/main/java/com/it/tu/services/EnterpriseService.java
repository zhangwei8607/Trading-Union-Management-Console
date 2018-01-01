package com.it.tu.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.it.tu.beans.Enterprise;
import com.it.tu.beans.EnterpriseQuery;
import com.it.tu.DAO.EnterpriseDao;
@Service
@Transactional
public class EnterpriseService extends EnterpriseService_Gen {

	@Autowired
	private EnterpriseDao repository;
	
}