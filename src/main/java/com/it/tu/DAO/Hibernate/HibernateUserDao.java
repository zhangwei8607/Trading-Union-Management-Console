package com.it.tu.DAO.Hibernate;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.it.tu.DAO.UserDao;
import com.it.tu.beans.User;

@Repository
@Transactional
public class HibernateUserDao implements UserDao 
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		return (List<User>)getCurrentSession().createQuery("from Users").list();
	}

	@Override
	@Transactional(readOnly=true)
	public User findUserById(int id) {
		User user = (User) getCurrentSession().get(User.class, id);
		return user;
	}
	
	@Override
	@Transactional(readOnly=true)
	public User findUserByEmail(String email) {
		Criteria criteria = getCurrentSession().createCriteria(User.class);

		criteria.add(Restrictions.eq("email", email));
		
		try {
			return (User)criteria.list().get(0);
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public User findUserByName(String name) {
		Criteria criteria = getCurrentSession().createCriteria(User.class);

		criteria.add(Restrictions.eq("name", name));
		
		try {
			return (User)criteria.list().get(0);
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void create(User user) {
		getCurrentSession().save(user);
	}

	public void update(User user) {
		User u = findUserById(user.getId());
		u.setName(user.getName());
		getCurrentSession().update(u);
	}

	public void delete(int id) {
		User user = findUserById(id);
		if (user != null)
			getCurrentSession().delete(user);
	}

	@Override
	public User login(String email, String password) {
		
		Criteria criteria = getCurrentSession().createCriteria(User.class);

		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));
		
		try {
			return (User)criteria.list().get(0);
		} catch (NoResultException e) {
			return null;
		}
		
	}
	
}

