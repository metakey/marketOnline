package com.netease.marketOnline.dao;

import com.netease.marketOnline.meta.UserFromDB;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.netease.marketOnline.meta.User;

public interface UserDAO {
	@Select("select * from person where username=#{username}")
	public UserFromDB getUser(@Param("username")String username);
	

}
