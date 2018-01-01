package com.it.tu.DAO.Hibernate;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.tu.DAO.CategoryItemDao;
import com.it.tu.beans.CategoryItem;
import com.it.tu.beans.CategoryIDClass;


@Repository
@Transactional
public class HibernateCategoryItemDAO implements CategoryItemDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void update(CategoryItem item) {
		// TODO Auto-generated method stub
		CategoryItem it=findById(item.getkey());
		it.setCd(item.getCd());
		it.setName(item.getName());
		it.setEname(item.getEname());
		it.setDescription(item.getDescription());
		it.setShoworder(item.getShoworder());
		it.setStatus(item.getStatus());
		getCurrentSession().update(it);
	}

	@Override
	@Transactional(readOnly = true) 
	public CategoryItem findById(CategoryIDClass idkey) {
		// TODO Auto-generated method stub
		CategoryItem item = findByCategoryId(idkey).get(0);
		return item;
	}

	@Override
	@Transactional(readOnly = true) 
	public CategoryItem findByCd(String cd) {
		// TODO Auto-generated method stub
		Criteria criteria = getCurrentSession().createCriteria(CategoryItem.class);
		criteria.add(Restrictions.eq("CD", cd));
		CategoryItem item = (CategoryItem)criteria.list().get(0);
		return item;
	}

	@Override
	@Transactional(readOnly = true) 
	public List<CategoryItem> findByCategoryId(CategoryIDClass key)
	{
		String sql="from CategoryItem d where 1=1";
		if(key.getCategoryId() != 0)
		{
			sql += " and  d.key.categoryId =:categoryId ";
		}
		if(key.getId()!=0)
		{
			sql += " and d.key.id = :id";
		}
		Query q=getCurrentSession().createQuery(sql);
		if(key.getCategoryId() != 0)
			q.setParameter("categoryId", key.getCategoryId());
		if(key.getId() != 0)
			q.setParameter("id", key.getId());
		List<CategoryItem> itemList = (List<CategoryItem>)q.list();
		return itemList;
	}
}
