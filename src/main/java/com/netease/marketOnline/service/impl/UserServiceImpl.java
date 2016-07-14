package com.netease.marketOnline.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.netease.marketOnline.dao.UserDAO;
import com.netease.marketOnline.meta.User;
import com.netease.marketOnline.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDAO userDAO;
	
	public User getUserByUsername(String username) {
		User user = null;
		user = this.userDAO.getUser(username);
		return user;
	}

	public String getPassword(String username) {
		String password=this.userDAO.getPassword(username);
		return password;
	}
	
	
}
