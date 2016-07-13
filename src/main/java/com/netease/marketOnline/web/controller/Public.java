package com.netease.marketOnline.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netease.marketOnline.meta.User;

@Controller
public class Public {
	@RequestMapping(value="/public", method=RequestMethod.GET)
	public String publicPage(HttpSession session, Model model){
		String userName=(String)session.getAttribute("username");
		Integer usertype=(Integer)session.getAttribute("usertype");
		User user = null;
		if(userName!=null && usertype==1){
			user=new User();
			user.setUsername(userName);
			user.setUsertype(usertype);
		}
		model.addAttribute("user", user);
		return "public";
	}
	
}
