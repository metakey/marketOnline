package com.netease.marketOnline.service;

import com.netease.marketOnline.meta.User;
import com.netease.marketOnline.meta.UserFromDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.marketOnline.dao.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	//函数名称不好
	public  boolean validateUser(UserFromDB user,String password){
		if (user!=null && user.getPassword().equals(password)){
			return true;
		}
		return false;
	}
	public UserFromDB getUser(String userName){
		return userDAO.getUser(userName);
	}
}
