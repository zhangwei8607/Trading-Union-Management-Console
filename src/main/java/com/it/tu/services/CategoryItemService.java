package com.it.tu.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.it.tu.DAO.CategoryItemDao;
import com.it.tu.beans.CategoryIDClass;
import com.it.tu.beans.CategoryItem;

@Service
@Transactional
public class CategoryItemService {

	@Autowired 
	private CategoryItemDao categoryitem;
	
	public void update(CategoryItem item)
	{
		this.categoryitem.update(item);
	}
	public CategoryItem findById(CategoryIDClass key)
	{
		return categoryitem.findById(key);
	}
	public CategoryItem findByCd(String cd)
	{
		return categoryitem.findByCd(cd);
	}
	public List<CategoryItem> findByCategoryId(int categoryid)
	{
		CategoryIDClass idkey=new CategoryIDClass();
		idkey.setCategoryId(categoryid);
		return categoryitem.findByCategoryId(idkey);
	}
}
