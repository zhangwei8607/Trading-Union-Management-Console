package com.it.tu.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.it.tu.beans.EnterpriseRegister;
import com.it.tu.beans.EnterpriseRegisterQuery;
import com.it.tu.DAO.EnterpriseRegisterDao;
@Service
@Transactional
public class EnterpriseRegisterService extends EnterpriseRegisterService_Gen {

	@Autowired
	private EnterpriseRegisterDao repository;
	
}