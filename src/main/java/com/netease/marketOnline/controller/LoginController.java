package com.netease.marketOnline.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netease.marketOnline.meta.User;
import com.netease.marketOnline.service.UserService;

@Controller
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private UserService userServiceImpl;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public Object login(@RequestParam("userName") String userName, 
			@RequestParam("password") String password, 
			HttpSession session) {
				
		Map<String, Object> result=new HashMap<String, Object>();
		User user = userServiceImpl.getUserByUsername(userName);
		
		boolean loginSuccess=judgeUser(user, password);
		if (user != null && password.equals(userServiceImpl.getPassword(userName))) {
			loginSuccess = true;
		}
		
		if(loginSuccess){
			result.put("result", true);
			result.put("code", 200);
			session.setAttribute("userid", user.getId());
			session.setAttribute("username", user.getUsername());
			session.setAttribute("usertype", user.getUsertype());
		}else{
			result.put("code", 400);
			result.put("result", false);
			result.put("message", "用户名或密码错误");
		}
		return result;
	}
	
	private boolean judgeUser(User user,String password){
		if (user!=null && password.equals(userServiceImpl.getPassword(user.getUsername()))){
			return true;
		}
		return false;
	}
}
