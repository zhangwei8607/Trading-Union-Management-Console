package com.it.tu.DAO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.it.tu.beans.CategoryIDClass;
import com.it.tu.beans.CategoryItem;

@Component
public interface CategoryItemDao {

	public void update(CategoryItem item);
	public CategoryItem findById(CategoryIDClass idkey);
	public CategoryItem findByCd(String cd);
	public List<CategoryItem> findByCategoryId(CategoryIDClass key);
	
}
