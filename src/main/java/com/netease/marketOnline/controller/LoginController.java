package com.netease.marketOnline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public void login(@RequestParam("userName") String userName, 
			@RequestParam("password") String password) {
		
	}
}
