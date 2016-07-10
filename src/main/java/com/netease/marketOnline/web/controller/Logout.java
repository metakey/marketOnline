package com.netease.marketOnline.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Logout {
	@RequestMapping("/logout")
	public String logoutPage(HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("usertype");
		return "index";//redirect方式
	}
}
