package com.it.tu.DAO;

import java.util.List;

import org.springframework.stereotype.Component;


import com.it.tu.beans.Category;

@Component
public interface CategoryDao {
	
	public Category findById(int id);
	public Category findByCd(String cd);
	public List<Category> findListByModule(String module);
}
