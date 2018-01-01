package com.it.tu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.it.tu.beans.Category;
import com.it.tu.DAO.CategoryDao;

@Service
@Transactional
public class CategoryServices {

	@Autowired 
	private CategoryDao category;
	
	public Category findById(int id)
	{
		return category.findById(id);
	}
	
	public Category findByCd(String cd)
	{
		return category.findByCd(cd);
	}
	public List<Category> findListByModule(String module)
	{
		return category.findListByModule(module);
	}
}
