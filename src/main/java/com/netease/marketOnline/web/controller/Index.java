package com.netease.marketOnline.web.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netease.marketOnline.meta.Product;
import com.netease.marketOnline.meta.User;

@Controller
public class Index {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String indexPage(HttpSession session,Model model) {
		
		User user=null;
		String userName=(String)session.getAttribute("username");
		Integer usertype=(Integer)session.getAttribute("usertype");
		if(userName!=null&&usertype!=null){
			user=new User();
			user.setUsername(userName);
			user.setUsertype(usertype);
		}
		List<Product> productList = new LinkedList<Product>();
		Product p1 =new Product();
		p1.setId(0001);
		p1.setTitle("第1种商品");
		p1.setPrice(1);
		p1.setImage("http://nec.netease.com/img/s/1.jpg");
		p1.setBuy(false);
		p1.setSell(false);
		
		Product p2 =new Product();
		p2.setId(0002);
		p2.setTitle("第2种商品");
		p2.setPrice(2);
		p2.setImage("http://nec.netease.com/img/s/1.jpg");
		p2.setBuy(true);
		p2.setSell(true);
		productList.add(p1);
		productList.add(p2);
		
		model.addAttribute("user", user);
		model.addAttribute("productList", productList);
		return "index";
	}
}

