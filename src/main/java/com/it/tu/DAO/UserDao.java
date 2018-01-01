/**
 * 
 */
package com.it.tu.DAO;

import java.util.List;

import com.it.tu.beans.User;


public interface UserDao {

	public List<User> findAll();
	public void create(User user);
	public void update(User user);
	public User findUserById(int id);
	public User findUserByEmail(String email);
	public User findUserByName(String name);
	public void delete(int id);
	public User login(String email, String password);
	
}
