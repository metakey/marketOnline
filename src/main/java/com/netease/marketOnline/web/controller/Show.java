package com.netease.marketOnline.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.netease.marketOnline.meta.Product;
import com.netease.marketOnline.meta.User;

@Controller
public class Show {
	@RequestMapping(value="/show", method=RequestMethod.GET)
	public String show(@RequestParam("id") int id, HttpSession session, Model model) {
		User user=null;
		String userName=(String)session.getAttribute("username");
		Integer usertype=(Integer)session.getAttribute("usertype");
		if(userName!=null&&usertype!=null){
			user=new User();
			user.setUsername(userName);
			user.setUsertype(usertype);
		}
		
		Product p1 = new Product();
		p1.setId(id);
		p1.setTitle("标题");
		p1.setSummary("摘要");
		p1.setDetail("全文");
		p1.setImage("http://nec.netease.com/img/s/1.jpg");
		p1.setPrice(0);
		p1.setBuyPrice(0);
		p1.setBuyNum(0);
		p1.setSaleNum(0);
		p1.setBuy(false);
		p1.setSell(false);
		
		
		
		model.addAttribute("user", user);
		model.addAttribute("product", p1);
		return "show";
	}
}
