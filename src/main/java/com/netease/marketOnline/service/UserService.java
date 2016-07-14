package com.netease.marketOnline.service;

import com.netease.marketOnline.meta.User;

public interface UserService {
	public User getUserByUsername(String username);
	public String getPassword(String username);
}
