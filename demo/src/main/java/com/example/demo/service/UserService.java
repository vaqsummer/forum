package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User getUserByName(String name) {
		User user = userDao.selectByName(name);
		return user;
	}
}
