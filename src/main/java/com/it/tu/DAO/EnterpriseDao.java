package com.it.tu.DAO;

import java.util.List;
import org.springframework.stereotype.Component;
import com.it.tu.beans.Enterprise;
import com.it.tu.beans.EnterpriseQuery;

@Component
public interface EnterpriseDao {

	public void create(Enterprise _enterprise);
	public void update(Enterprise _enterprise);
	public void delete(Integer id);
	public List<Enterprise> findAll();
	public Enterprise findById(Integer id);
	public List<Enterprise> findByQuery(EnterpriseQuery query);

}