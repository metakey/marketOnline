package com.netease.marketOnline.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class LoginController {
	
	private static Map<String,String> users=new HashMap<String, String>();
	
	static {
		users.put("buyer", "37254660e226ea65ce6f1efd54233424");
		users.put("seller", "981c57a5cfb0f868e064904b8745766f");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public Object login(@RequestParam("userName") String userName, 
			@RequestParam("password") String password, 
			HttpSession session) {
		Map<String, String> result=new HashMap<String, String>();
		boolean loginSuccess=judgeUser(userName, password);
		if(loginSuccess){
			result.put("result", "true");
			result.put("code", "200");
			session.setAttribute("username", userName);
			if (userName.equals("buyer")) {
				session.setAttribute("usertype", 0);
			} else if (userName.equals("seller")) {
				session.setAttribute("usertype", 1);
			}
		}else{
			System.out.println("login fail:"+userName);
			result.put("code", "400");
			result.put("result", "false");
			result.put("message", "用户名或密码错误");
		}
		return result;
	}
	private boolean judgeUser(String userName,String password){
		if(!users.containsKey(userName)){
			return false;
		}
		if(!users.get(userName).equals(password)){
			return false;
		}
		return true;
	}
}
