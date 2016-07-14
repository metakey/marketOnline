package com.netease.marketOnline.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.netease.marketOnline.meta.User;

public interface UserDAO {
	
	@Select("select * from person where username=#{username}")
	public User getUser(@Param("username")String username);
	
	@Select("select password from person where username=#{username}")
	public String getPassword(@Param("username") String username);
}
