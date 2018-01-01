package com.it.tu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.it.tu.DAO.DAOCliente;
import com.it.tu.beans.Cliente;

@Service
@Transactional
public class ClienteService {
	@Autowired
	private DAOCliente daoCliente;

	public void addCliente(Cliente cliente) {
		daoCliente.addCliente(cliente);		
	}

	public void updateCliente(Cliente cliente) {
		daoCliente.updateCliente(cliente);
	}

	public Cliente getCliente(int id) {
		return daoCliente.getCliente(id);
	}

	public void deleteCliente(int id) {
		daoCliente.deleteCliente(id);
	}

	public List getClientes() {
		return daoCliente.getClientes();
	}
}
