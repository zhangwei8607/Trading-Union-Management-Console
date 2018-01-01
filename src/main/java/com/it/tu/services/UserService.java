/**
 * 
 */
package com.it.tu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.it.tu.DAO.UserDao;
import com.it.tu.beans.User;

@Service
@Transactional
public class UserService 
{
	//private UserDao userDao;
	
	@Autowired
	private UserDao userRepository;
	
	/*
	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	*/
	public List<User> findAll() {
		//return userDao.findAll();
		return userRepository.findAll();
	}

	public void create(User user) {
		//return userDao.create(user);
	    userRepository.create(user);
	}

	public User findUserById(int id) {
		//return userDao.findUserById(id);
		return userRepository.findUserById(id);
	}

	public User login(String email, String password) {
		//return userDao.login(email,password);
		//return userRepository.login(email,password);
		return userRepository.login(email,password);
	}

	public void update(User user) {
		userRepository.update(user);
	}

	public void deleteUser(int id) {
		userRepository.delete(id);
	}

	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	
	public User findUserByName(String name) {
		return userRepository.findUserByName(name);
	}
}

