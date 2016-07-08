package com.netease.marketOnline.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netease.marketOnline.meta.User;

@Controller
@RequestMapping("/")
public class Test {
	@RequestMapping("test")
	public String testftl(Model model) {
		User user = null;
		model.addAttribute("name", "sss");
		model.addAttribute("password", "yyy");
		return "test";	
		}
}
