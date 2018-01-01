package com.it.tu.DAO.Hibernate;

import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class HibernateEnterpriseDao extends HibernateEnterpriseDao_Gen {

	@Autowired
	private static SessionFactory sessionFactory;

	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
	     super.setSessionFactory(sessionFactory);
	}

}
