package com.it.tu.DAO.Hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.it.tu.DAO.DAOCliente;
import com.it.tu.beans.Cliente;


@Repository
public class HibernateDAO implements DAOCliente {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addCliente(Cliente Cliente) {
		getCurrentSession().save(Cliente);
	}

	public void updateCliente(Cliente Cliente) {
		Cliente ClienteToUpdate = getCliente(Cliente.getId());
		ClienteToUpdate.setNome(Cliente.getNome());
		getCurrentSession().update(ClienteToUpdate);

	}

	public Cliente getCliente(int id) {
		Cliente cliente = (Cliente) getCurrentSession().get(Cliente.class, id);
		return cliente;
	}

	public void deleteCliente(int id) {
		Cliente cliente = getCliente(id);
		if (cliente != null)
			getCurrentSession().delete(cliente);
	}

	public List getClientes() {
		return getCurrentSession().createQuery("from Cliente").list();
	}

}