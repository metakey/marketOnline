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
public class Edit {
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(@RequestParam("id") int id, HttpSession session, Model model) {
		String userName=(String)session.getAttribute("username");
		Integer usertype=(Integer)session.getAttribute("usertype");
		User user = null;
		if(userName!=null && usertype==1){
			user=new User();
			user.setUsername(userName);
			user.setUsertype(usertype);
			model.addAttribute("user", user);
		}
		
		//根据id获取product
		Product product = null;
				
		if (true) { //根据id成功获取product
			product = new Product();
			product.setId(id);
			product.setTitle("设置标题");
			product.setSummary("设置摘要");
			product.setDetail("设置全文");
			product.setImage("http://nec.netease.com/img/s/1.jpg");
			product.setPrice(777);
			model.addAttribute("product", product);
		}
		
		
		return "edit";
	}
}
