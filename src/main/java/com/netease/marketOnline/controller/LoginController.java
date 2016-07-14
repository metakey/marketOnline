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
	
//	private static Map<String,String> users=new HashMap<String, String>();
//	
//	static {
//		users.put("buyer", "37254660e226ea65ce6f1efd54233424");
//		users.put("seller", "981c57a5cfb0f868e064904b8745766f");
//	}
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public Object login(@RequestParam("userName") String userName, 
			@RequestParam("password") String password, 
			HttpSession session) {
				
		Map<String, Object> result=new HashMap<String, Object>();
		User user = userService.getUserByUsername(userName);
		
		boolean loginSuccess=false;
		if (user != null && password.equals(userService.getPassword(userName))) {
			loginSuccess = true;
		}
		
		if(loginSuccess){
			result.put("result", true);
			result.put("code", 200);
			session.setAttribute("username", user.getUsername());
			session.setAttribute("usertype", user.getUsertype());
		}else{
			result.put("code", 400);
			result.put("result", false);
			result.put("message", "用户名或密码错误");
		}
		return result;
	}
}
