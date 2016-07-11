package com.netease.marketOnline.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Logout {
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutPage(HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("usertype");
		return "index";//redirect方式
	}
}
