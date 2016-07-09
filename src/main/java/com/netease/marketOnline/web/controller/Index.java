package com.netease.marketOnline.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netease.marketOnline.meta.User;

@Controller
public class Index {
	@RequestMapping("/")
	public String indexPage(Model model) {
		User user=null;

		model.addAttribute("user", user);
		return "index";
	}
}

