package com.it.tu.DAO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.it.tu.beans.Cliente;

@Component
public interface DAOCliente { 

	public void addCliente(Cliente cliente);
	public void updateCliente(Cliente cliente);
	public Cliente getCliente(int id);
	public void deleteCliente(int id);
	public List getClientes();
}
