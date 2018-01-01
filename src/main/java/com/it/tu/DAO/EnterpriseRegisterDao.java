package com.it.tu.DAO;

import java.util.List;
import org.springframework.stereotype.Component;
import com.it.tu.beans.EnterpriseRegister;
import com.it.tu.beans.EnterpriseRegisterQuery;

@Component
public interface EnterpriseRegisterDao {

	public void create(EnterpriseRegister _enterpriseregister);
	public void update(EnterpriseRegister _enterpriseregister);
	public void delete(Integer id);
	public List<EnterpriseRegister> findAll();
	public EnterpriseRegister findById(Integer id);
	public List<EnterpriseRegister> findByQuery(EnterpriseRegisterQuery query);

}