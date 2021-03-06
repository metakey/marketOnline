package com.netease.marketOnline.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Logout {
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public void logoutPage(HttpServletResponse resonpse, HttpSession session) {
		session.invalidate();
		try {
			resonpse.sendRedirect("/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
