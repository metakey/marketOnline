package com.netease.marketOnline.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.netease.marketOnline.meta.UserFromDB;
import com.netease.marketOnline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public Object login( @RequestParam("userName") String userName,
			@RequestParam("password") String password,
			HttpSession session) {
		//检查用户名密码不是空
		Map<String, Object> result=new HashMap<String, Object>();
		UserFromDB userFromDB=userService.getUser(userName);
		boolean loginSuccess=userService.validateUser(userFromDB,password);
		if(loginSuccess){
			result.put("result", true);
			result.put("code", 200);
			session.setAttribute("userid", userFromDB.getId());
			session.setAttribute("username", userFromDB.getUsername());
			session.setAttribute("usertype", userFromDB.getUsertype());
		}else{
			result.put("result", false);
			result.put("code", 400);
			result.put("message", "用户名或密码错误");
		}
		return result;
	}

}
