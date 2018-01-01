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

import com.it.tu.DAO.CategoryDao;
import com.it.tu.beans.Category;
import com.it.tu.beans.CategoryItem;

@Repository
@Transactional
public class HibernateCategoryDAO implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	@Transactional(readOnly = true) 
	public Category findById(int id) {
		// TODO Auto-generated method stub
		Criteria criteria = getCurrentSession().createCriteria(Category.class);
		criteria.add(Restrictions.eq("ID", id));
		Category category=(Category)criteria.list().get(0);
		return category;
	}

	@Override
	@Transactional(readOnly = true) 
	public Category findByCd(String cd) {
		// TODO Auto-generated method stub
		Criteria criteria = getCurrentSession().createCriteria(Category.class);
		criteria.add(Restrictions.eq("CD", cd));
		Category category=(Category)criteria.list().get(0);
		return category;
	}

	@Override
	@Transactional(readOnly = true) 
	public List<Category> findListByModule(String module) {
		// TODO Auto-generated method stub
		Criteria criteria = getCurrentSession().createCriteria(Category.class);
		criteria.add(Restrictions.eq("Module", module));
		List<Category> list = (List<Category>)criteria.list();
		return list;
	}

	
}
